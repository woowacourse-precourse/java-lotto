package lotto;

import java.util.*;

import static java.util.Comparator.*;

public class LottoResult {
    private Map<LottoRank, Integer> rankResult;
    private long totalPrize;
    private double totalReturnRatio;

    public LottoResult(List<LottoRank> winningResult, int purchaseAmount) {
        initRankResult();
        updateRankResult(winningResult);
        sortRankResult(comparingLong(result -> result.getKey().winningPrize));
        this.totalPrize = calcTotalPrize(this.rankResult);
        this.totalReturnRatio = Math.round((double) totalPrize / purchaseAmount * 1000) / 10.0;
    }

    public void sortRankResult(Comparator<Map.Entry<LottoRank, Integer>> comparator) {
        Objects.requireNonNull(comparator);

        List<Map.Entry<LottoRank, Integer>> results = new ArrayList<>(this.rankResult.entrySet());
        results.sort(comparator);

        Map<LottoRank, Integer> rankResult = new LinkedHashMap<>();
        for (Map.Entry<LottoRank, Integer> result : results) {
            rankResult.put(result.getKey(), result.getValue());
        }
        this.rankResult = rankResult;
    }

    private void initRankResult() {
        Map<LottoRank, Integer> rankResult = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankResult.put(rank, 0);
        }
        this.rankResult = rankResult;
    }

    private void updateRankResult(List<LottoRank> winningResult) {
        for (LottoRank rank : winningResult) {
            this.rankResult.put(rank, this.rankResult.get(rank) + 1);
        }
    }

    private long calcTotalPrize(Map<LottoRank, Integer> rankResult) {
        return rankResult.entrySet().stream()
                .map(result -> result.getKey().winningPrize * result.getValue())
                .reduce(0L, Long::sum);
    }

    public Map<LottoRank, Integer> getRankResult() {
        return rankResult;
    }

    public double getTotalReturnRatio() {
        return totalReturnRatio;
    }

    public long getTotalPrize() {
        return totalPrize;
    }
}