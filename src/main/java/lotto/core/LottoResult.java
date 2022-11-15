package lotto.core;

import static java.util.Comparator.comparingLong;

import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Objects;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LottoResult {
    private int purchaseAmount;
    private Map<LottoRank, Integer> totalRankingResult;
    private long totalPrize;
    private double totalReturnRatio;

    public LottoResult(List<LottoRank> winningResult) {
        initTotalRankingResult();
        updateTotalRankingResult(winningResult);
        sortTotalRankingResult(comparingLong(result -> result.getKey().winningPrize));
        this.purchaseAmount = winningResult.size() * LotteryPublisher.LOTTO_PRICE;
        this.totalPrize = calcTotalPrize(this.totalRankingResult);
        this.totalReturnRatio = Math.round((double) totalPrize / purchaseAmount * 10000) / 100.0;
    }

    public void sortTotalRankingResult(Comparator<Map.Entry<LottoRank, Integer>> comparator) {
        Objects.requireNonNull(comparator);

        List<Map.Entry<LottoRank, Integer>> results = new ArrayList<>(this.totalRankingResult.entrySet());
        results.sort(comparator);

        Map<LottoRank, Integer> totalRankingResult = new LinkedHashMap<>();
        for (Map.Entry<LottoRank, Integer> result : results) {
            totalRankingResult.put(result.getKey(), result.getValue());
        }
        this.totalRankingResult = totalRankingResult;
    }

    private void initTotalRankingResult() {
        Map<LottoRank, Integer> totalRankingResult = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            totalRankingResult.put(rank, 0);
        }
        this.totalRankingResult = totalRankingResult;
    }

    private void updateTotalRankingResult(List<LottoRank> winningResult) {
        for (LottoRank rank : winningResult) {
            this.totalRankingResult.put(rank, this.totalRankingResult.get(rank) + 1);
        }
    }

    private long calcTotalPrize(Map<LottoRank, Integer> totalRankingResult) {
        return totalRankingResult.entrySet().stream()
                .map(result -> result.getKey().winningPrize * result.getValue())
                .reduce(0L, Long::sum);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public Map<LottoRank, Integer> getTotalRankingResult() {
        return totalRankingResult;
    }

    public double getTotalReturnRatio() {
        return totalReturnRatio;
    }

    public long getTotalPrize() {
        return totalPrize;
    }
}