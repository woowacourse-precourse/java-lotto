package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.LottoCalculate.LottoPrizeMoneyMatchCount;

public class LottoData {
    public double money;
    public int bonusNumber;
    public int lottoAmount;
    public double prizeMoneySum;
    public List<Integer> winNumbers;
    public List<Lotto> allLotto;
    public PrizeData prize;
    private final LottoCalculate lottoCalculate = new LottoCalculate();

    public LottoData(double money) {
        this.money = money;
        this.lottoAmount = (int) (money / 1000);
        allLotto = new ArrayList<>(lottoAmount);
        prize = new PrizeData();
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
        prize.addPrizeCount(lottoPrizeMoneyMatchCount.prize);
        prizeMoneySum += lottoPrizeMoneyMatchCount.prizeMoney;
    }

    public float percentageOfReturn() {
        return lottoCalculate.calculatePercentageOfReturn(money, prizeMoneySum);
    }

    void saveWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    void saveBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
