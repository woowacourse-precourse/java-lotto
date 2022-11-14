package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private List<Lotto> lotteries = new ArrayList<>();
    private int lottoCount;
    private List<Integer> lottoResults = Arrays.asList(0, 0, 0, 0, 0, 0, 0);
    private int bonusResult = 0;
    private double rateOfReturn;

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int countLotto(int cost) {
        lottoCount = cost / 1000;

        return lottoCount;
    }

    public List<Lotto> createRandomLotto() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotteries.add(new Lotto(lottoNumber));
        }

        return lotteries;
    }

    public void compareEachLotto(WinningLotto winningLotto) {
        for (Lotto lottery:lotteries) {
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
        rateOfReturn = ((calculateProfit()) / (lottoCount * 1000.0)) * 100;
    }

    private int calculateProfit() {
        int profit = (5000 * lottoResults.get(3)) + (50000 * lottoResults.get(4)) + (1500000 * (lottoResults.get(5)-bonusResult))
                + (30000000 * bonusResult) + (2000000000 * lottoResults.get(6));

        return profit;
    }

    public String toString() {
        return "3개 일치 (5,000원) - " + lottoResults.get(3) + "개\n" +
                "4개 일치 (50,000원) - " + lottoResults.get(4) + "개\n" +
                "5개 일치 (1,500,000원) - " + (lottoResults.get(5) - bonusResult) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonusResult + "개\n" +
                "6개 일치 (2,000,000,000원) - " + lottoResults.get(6) + "개\n" +
                "총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.";
    }
}
