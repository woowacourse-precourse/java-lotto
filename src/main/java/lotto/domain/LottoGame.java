package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private static final int EACH_LOTTO_COST = 1000;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private int lottoCount;
    private int bonusResult = 0;
    private double rateOfReturn;
    private List<Integer> lottoResults = Arrays.asList(0, 0, 0, 0, 0, 0, 0);

    private List<Lotto> lotteries = new ArrayList<>();

    public LottoGame() {
    }

    public LottoGame(List<Integer> lottoResults, int lottoCount) {
        this.lottoResults = lottoResults;
        this.lottoCount = lottoCount;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int countLotto(int cost) {
        lottoCount = cost / EACH_LOTTO_COST;

        return lottoCount;
    }

    public void createRandomLotto() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT);
            lotteries.add(new Lotto(lottoNumber));
        }
    }

    public void compareEachLotto(WinningLotto winningLotto) {
        for (Lotto lottery : lotteries) {
            int result = winningLotto.compareLotto(lottery);

            setLottoResults(result);
            setBonusResult(winningLotto, lottery, result);
        }
    }

    private void setLottoResults(int result) {
        int count = lottoResults.get(result);

        count++;
        lottoResults.set(result, count);
    }

    private void setBonusResult(WinningLotto winningLotto, Lotto lotto, int result) {
        if (winningLotto.isBonusInLotto(lotto) && result == 5) {
            bonusResult++;
        }
    }

    public void setRateOfReturn() {
        rateOfReturn = ((calculateProfit()) / (lottoCount * EACH_LOTTO_COST)) * 100;
    }

    private double calculateProfit() {
        double profit = 0;
        Prize first = Prize.CALCULATE_FIRST;
        profit += first.calculate(lottoResults.get(6));
        Prize second = Prize.CALCULATE_SECOND;
        profit += second.calculate(bonusResult);
        Prize third = Prize.CALCULATE_THIRD;
        profit += third.calculate((lottoResults.get(5) - bonusResult));
        Prize fourth = Prize.CALCULATE_FOURTH;
        profit += fourth.calculate(lottoResults.get(4));
        Prize fifth = Prize.CALCULATE_FIFTH;
        profit += fifth.calculate(lottoResults.get(3));

        return profit;
    }

    public String rankCountResult() {
        return "3개 일치 (5,000원) - " + lottoResults.get(3) + "개\n" +
                "4개 일치 (50,000원) - " + lottoResults.get(4) + "개\n" +
                "5개 일치 (1,500,000원) - " + (lottoResults.get(5) - bonusResult) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonusResult + "개\n" +
                "6개 일치 (2,000,000,000원) - " + lottoResults.get(6) + "개";
    }

    public String profitRateResult() {
        return "총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.";
    }
}
