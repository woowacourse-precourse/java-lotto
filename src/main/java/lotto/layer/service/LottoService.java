package lotto.layer.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.layer.db.Table;

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

    public Map<Rank, Integer> getRankFrequency(Lotto commonLotto, LottoNumber bonusNumber) {
        validateDuplicate(commonLotto, bonusNumber);
        List<Lotto> lotteries = table.getLotteries();
        Map<Rank, Integer> frequency = initRankFrequency();
        for (Lotto lotto : lotteries) {
            Rank rank = getRank(commonLotto, bonusNumber, lotto);
            if (rank == null) {
                continue;
            }
            frequency.put(rank, frequency.getOrDefault(rank, 0) + 1);
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
        Map<Rank, Integer> frequency = table.getFrequency();
        return calculateBenefitRate(money, frequency);
    }

    private double calculateBenefitRate(Money money, Map<Rank, Integer> frequency) {
        int totalSum = 0;
        for (Entry<Rank, Integer> rankEntry : frequency.entrySet()) {
            Rank rank = rankEntry.getKey();
            int count = rankEntry.getValue();
            int rankMoney = rank.getMoneyValue();
            totalSum += rankMoney * count;
        }
        double benefitRate = (double) totalSum / money.intValue();
        benefitRate *= 100;
        return benefitRate;
    }

    private Map<Rank, Integer> initRankFrequency() {
        Map<Rank, Integer> frequency = new HashMap<>();
        for (Rank rank : Rank.values()) {
            frequency.put(rank, 0);
        }
        return frequency;
    }

    private Rank getRank(Lotto commonLotto, LottoNumber bonusNumber, Lotto generatedLotto) {
        int matchScore = calculateCommonMatchScore(commonLotto, generatedLotto);
        boolean bonusNumberMatch = isBonusNumberMatch(bonusNumber, generatedLotto);
        return Rank.matchOf(matchScore, bonusNumberMatch);
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