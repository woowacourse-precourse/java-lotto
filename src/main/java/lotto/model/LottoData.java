package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.LottoCalculate.LottoPrizeMoneyMatchCount;

public class LottoData {
    public int lottoAmount;
    public double prizeMoneySum;
    public Map<Integer, Integer> prize;
    public List<Lotto> allLotto;
    LottoCalculate lottoCalculate = new LottoCalculate();

    public LottoData(double money) {
        this.lottoAmount = (int) (money / 1000);
        allLotto = new ArrayList<>(lottoAmount);
        prize = new HashMap<>();
        prize.put(1, 0);
        prize.put(2, 0);
        prize.put(3, 0);
        prize.put(4, 0);
        prize.put(5, 0);
        prizeMoneySum = 0;
    }

    public void makeLotto() {
        List<Integer> lottoNumbers;
        while (allLotto.size() != lottoAmount) {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            int[] integerNumbers = lottoNumbers.stream().mapToInt(number -> number).toArray();
            Arrays.sort(integerNumbers);
            Lotto lotto = new Lotto(Arrays.stream(integerNumbers).boxed().collect(Collectors.toList()));
            allLotto.add(lotto);
        }
    }

    public void putDataToLotto(List<Integer> winNumbers, int bonusNumber) {
        for (Lotto lotto : allLotto) {
            totalCalculate(lotto, winNumbers, bonusNumber);
        }
    }

    void totalCalculate(Lotto lotto, List<Integer> winNumbers, int bonusNumber) {
        int matchCount = lottoCalculate.checkMatches(lotto.getNumbers(), winNumbers);
        boolean matchBonusNumber = lottoCalculate.checkBonusNumber(lotto.getNumbers(), bonusNumber);
        LottoPrizeMoneyMatchCount lottoPrizeMoneyMatchCount = lottoCalculate.calculatePrize(matchCount,
                matchBonusNumber);
        prize.merge(lottoPrizeMoneyMatchCount.prize, 1, Integer::sum);
        prizeMoneySum += lottoPrizeMoneyMatchCount.prizeMoney;
    }

    public double percentageOfReturn() {
        return lottoCalculate.calculatePercentageOfReturn(lottoAmount * 1000.0, prizeMoneySum);
    }
}
