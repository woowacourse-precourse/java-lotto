package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.NumberValidate.digitValidate;
import static lotto.NumberValidate.inRangeValidate;

public class LottoStore {

    public List<Lotto> buyLottos(Money money) {
        int lottoCount = (int)(money.getMoney() / 1000);

        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<lottoCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }

    public Lotto confirmWinningNumbers(String winningNumber) {
        List<Integer> winningNumbers = Arrays.asList(winningNumber.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(winningNumbers);
    }

    public Integer confirmBonusNumber(String bonusNumber) {
        digitValidate(bonusNumber);
        inRangeValidate(Integer.parseInt(bonusNumber));
        return Integer.parseInt(bonusNumber);
    }

    public Map<LottoGrade, Integer> conversionLottosResult(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        Map<LottoGrade, Integer> totalResult = new EnumMap<>(LottoGrade.class);
        totalResult.put(LottoGrade.ONE, 0);
        totalResult.put(LottoGrade.TWO, 0);
        totalResult.put(LottoGrade.THREE, 0);
        totalResult.put(LottoGrade.FOUR, 0);
        totalResult.put(LottoGrade.FIVE, 0);

        List<LottoGrade> lottosResult = allLottosCompare(lottos, winningNumbers, bonusNumber);
        for (LottoGrade lottoGrade : lottosResult) {
            if (lottoGrade != LottoGrade.MISS) {
                totalResult.put(lottoGrade, totalResult.get(lottoGrade) + 1);
            }
        }

        return totalResult;
    }

    private List<LottoGrade> allLottosCompare(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        List<LottoGrade> lottosResult = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottosResult.add(lottoNumbersCompareToWinningNumbers(lotto, winningNumbers, bonusNumber));
        }
        return lottosResult;
    }

    private LottoGrade lottoNumbersCompareToWinningNumbers(Lotto lottoNumbers, Lotto winningNumbers, int bonusNumber) {
        int count = 0;
        boolean bonusBall = lottoNumbers.getNumbers().contains(bonusNumber);
        for (Integer number : lottoNumbers.getNumbers()) {
            if (winningNumbers.getNumbers().contains(number)) {
                count++;
            }
        }
        return LottoGrade.getRank(count, bonusBall);
    }

    public double revenueCalculator(Long money, Map<LottoGrade, Integer> lottosResult) {
        int sum = 0;
        for (LottoGrade key : lottosResult.keySet()) {
            if (lottosResult.get(key) != 0) {
                sum += lottosResult.get(key) * key.getPrice();
            }
        }
        return sum / Double.parseDouble(money.toString()) * 100.0;
    }
}
