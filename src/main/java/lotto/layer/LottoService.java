package lotto.layer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class LottoService {

    private static final String ERROR_DUPLICATE = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";
    private final Table table;

    public LottoService(Table table) {
        this.table = table;
    }

    public List<Lotto> generateLotteries(Money money) {
        table.clear();
        int lottoCount = money.intValue() / Money.UNIT;
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> uniqueNumbersInRange = Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_VALUE,
                    LottoNumber.MAX_VALUE, Lotto.LOTTO_LENGTH);
            lotteries.add(new Lotto(uniqueNumbersInRange));
        }
        table.saveLottoAll(lotteries);
        table.saveMoney(money);
        return lotteries;
    }

    public Map<WinningLotto, Integer> getWinningLottoFrequency(Lotto commonLotto, LottoNumber bonusNumber) {
        validateDuplicate(commonLotto, bonusNumber);
        List<Lotto> lotteries = table.getLotteries();
        Map<WinningLotto, Integer> frequency = initWinningLotto();
        for (Lotto lotto : lotteries) {
            WinningLotto winningLotto = getWinningLotto(commonLotto, bonusNumber, lotto);
            if (winningLotto == null) {
                continue;
            }
            frequency.put(winningLotto, frequency.getOrDefault(winningLotto, 0) + 1);
        }
        table.saveFrequency(frequency);
        return frequency;
    }

    private void validateDuplicate(Lotto commonLotto, LottoNumber bonusNumber) {
        if (commonLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    public double getBenefitRate() {
        Money money = table.getMoney();
        Map<WinningLotto, Integer> frequency = table.getFrequency();
        int totalSum = 0;
        for (Entry<WinningLotto, Integer> winningLottoEntry : frequency.entrySet()) {
            WinningLotto winningLotto = winningLottoEntry.getKey();
            int count = winningLottoEntry.getValue();
            int winningMoney = winningLotto.getMoneyValue();
            totalSum += winningMoney * count;
        }
        double benefitRate = (double) totalSum / money.intValue();
        benefitRate *= 100;
        return benefitRate;
    }

    private Map<WinningLotto, Integer> initWinningLotto() {
        Map<WinningLotto, Integer> frequency = new HashMap<>();
        for (WinningLotto winningLotto : WinningLotto.values()) {
            frequency.put(winningLotto, 0);
        }
        return frequency;
    }

    private WinningLotto getWinningLotto(Lotto commonLotto, LottoNumber bonusNumber, Lotto generatedLotto) {
        int matchScore = calculateCommonMatchScore(commonLotto, generatedLotto);
        boolean bonusNumberMatch = isBonusNumberMatch(bonusNumber, generatedLotto);
        return WinningLotto.matchOf(matchScore, bonusNumberMatch);
    }

    private int calculateCommonMatchScore(Lotto commonLotto, Lotto generatedLotto) {
        int commonMatchScore = 0;
        for (LottoNumber lottoNumber : commonLotto) {
            if (generatedLotto.contains(lottoNumber)) {
                commonMatchScore++;
            }
        }
        return commonMatchScore;
    }

    private boolean isBonusNumberMatch(LottoNumber bonusNumber, Lotto generatedLotto) {
        return generatedLotto.contains(bonusNumber);
    }
}