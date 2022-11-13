package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.dto.LottoStatsDTO;

public class LottoPurchase {
    private static final List<Integer> distribution = new ArrayList<>(
        List.of(5000, 50000, 1500000, 30000000, 2000000000));

    private static List<Integer> rankCounts = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    private static double yield = 0;
    private static List<Lotto> lottery;

    public LottoPurchase(List<Lotto> lottery) {
	this.lottery = lottery;
    }

    public void compareNumberByWinning(WinningLotto winningLotto) {
        for (Lotto lotto: lottery) {
            compareRankByNumber(winningLotto, lotto);
        }
    }

    public void calculateYieldPercent() {
        double revenue = 0;
        for (Integer index = 0; index < rankCounts.size(); ++index) {
            revenue += distribution.get(index) * rankCounts.get(index);
        }
        yield = (double)(Math.round(revenue / lottery.size())) / 10;
    }

    private void compareRankByNumber(WinningLotto winningLotto, Lotto lotto) {
        int rank = winningLotto.compareWinningLotto(lotto);
        if (rank >= 0) {
            rankCounts.set(rank, rankCounts.get(rank) + 1);
        }
    }

    public List<Lotto> getLottery() {
	return lottery;
    }

    public LottoStatsDTO getRankCounts() {
        return new LottoStatsDTO(rankCounts, yield);
    }
}
