package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int INITIAL_COUNT = 0;

    private final Map<Rank, Integer> lottoResult = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, INITIAL_COUNT);
        }
    }

    public Map<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public void addMatchRankCount(Lottos lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank matchedRank = lotto.getRank(winningNumbers);
            lottoResult.put(matchedRank, lottoResult.get(matchedRank) + 1);
        }
    }

    public double getLottoYield(LottoPurchaseAmount lottoPurchaseAmount) {
        double lottoReward = getTotalLottoReward();

        return Math.round((lottoReward / lottoPurchaseAmount.getPurchaseAmount() * 100) * 10) / 10.0;
    }

    public double getTotalLottoReward() {
        double lottoReward = 0.0;

        for (Rank rank : lottoResult.keySet()) {
            lottoReward += (rank.getReward() * lottoResult.get(rank));
        }

        return lottoReward;
    }
}
