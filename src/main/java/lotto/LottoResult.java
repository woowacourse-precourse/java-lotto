package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int MINIMUM_LOTTO_AMOUNT = 1000;

    private final Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
    private final List<Ranking> statistics;

    public LottoResult(List<Ranking> statistics) {
        init();
        this.statistics = statistics;
    }

    public Map<Ranking, Integer> matchWinningRank() {
        for (Ranking rank : this.statistics) {
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    public double getProfit(int numberOfLottoTickets) {
        int lottoAmount = numberOfLottoTickets * MINIMUM_LOTTO_AMOUNT;
        double sumOfPrize = 0;
        for (Ranking rank : result.keySet()) {
            if (rank == Ranking.NOTHING) {
                continue;
            }
            sumOfPrize += rank.getPrize() * result.get(rank);
        }
        return (sumOfPrize / lottoAmount) * 100;
    }

    private void init() {
        result.put(Ranking.NOTHING, 0);
        result.put(Ranking.FIFTH, 0);
        result.put(Ranking.FOURTH, 0);
        result.put(Ranking.THIRD, 0);
        result.put(Ranking.SECOND, 0);
        result.put(Ranking.FIRST, 0);
    }
}
