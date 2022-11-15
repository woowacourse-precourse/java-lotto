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
    private Map<LottoRank, Integer> rankResult;
    private long totalPrize;
    private double totalReturnRatio;

    public LottoResult(List<LottoRank> winningResult) {
        initRankResult();
        updateRankResult(winningResult);
        sortRankResult(comparingLong(result -> result.getKey().winningPrize));
        this.purchaseAmount = winningResult.size() * LotteryPublisher.LOTTO_PRICE;
        this.totalPrize = calcTotalPrize(this.rankResult);
        this.totalReturnRatio = Math.round((double) totalPrize / purchaseAmount * 10000) / 100.0;
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

    public int getPurchaseAmount() {
        return purchaseAmount;
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