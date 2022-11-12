package lotto.lottocomparator;

import java.util.Arrays;
import java.util.List;

/**
 * 1등 부터 5등까지 몇 번을 했는지, 총 당첨금은 얼마인지, 몇 개의 로또를 샀는지를 저장하는 클래스입니다.
 */
public class WinningLotto {
    private int lottoNumber;
    private int totalReward;
    private List<Integer> winningNumbers;
    public static List<Integer> winningReward = Arrays.asList(2000000000, 30000000, 1500000, 50000, 5000, 0);

    public WinningLotto() {
        this.lottoNumber = 0;
        this.totalReward = 0;
        this.winningNumbers = Arrays.asList(0, 0, 0, 0, 0, 0);
    }

    public int getTotalReward() {
        return totalReward;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    /**
     * 몇 등인지에 따라서 총 당첨금과 각 등수의 당첨 횟수를 갱신합니다.
     * @param rank 몇 등인지
     */
    public void updateResult(WinningRank rank) {
        winningNumbers.set(rank.getRank(), winningNumbers.get(rank.getRank()) + 1);
        totalReward += rank.getReward();
        lottoNumber++;
    }

    /**
     * 수익률을 계산하여 반환합니다.
     * @return 수익률
     */
    public double getRateOfRevenue() {
        return (double) totalReward / ((double) lottoNumber * 1000.0) * 100.0;
    }
}
