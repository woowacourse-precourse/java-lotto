package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.dto.LottoStatsDTO;

public class LottoPurchase {
    private static final Integer LOTTO_MINIMUM_RANK = 5;
    private static List<Lotto> lottery;
    private static List<Integer> rankCounts = new ArrayList<>(List.of(0, 0, 0, 0, 0));

    public LottoPurchase(List<Lotto> lottery) {
	this.lottery = lottery;
    }

    public void compareNumberByWinning() {
        for (Lotto lotto: lottery) {
            compareRankByNumber(lotto);
        }
    }

    private void compareRankByNumber(Lotto lotto) {
        int rank = WinningLotto.prepareWinningLotto(lotto);
        if (rank <= LOTTO_MINIMUM_RANK) {
            rankCounts.set(rank - 1, rankCounts.get(rank) + 1);
        }
    }

    public List<Lotto> getLottery() {
	return lottery;
    }
}
