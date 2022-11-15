package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final long ZERO = 0;

    private final Map<Rank, Long> statistics;

    private LottoResult(Map<Rank, Long> statistics) {
        this.statistics = new EnumMap<>(statistics);
    }

    public static LottoResult from(Map<Rank, Long> statistics) {
        initiateDefaultEntry(statistics);
        return new LottoResult(statistics);
    }

    private static void initiateDefaultEntry(Map<Rank, Long> statistics) {
        Arrays.stream(Rank.values())
                .forEach(rank -> statistics.computeIfAbsent(rank, key -> ZERO));
    }

    public double calculateYield(int totalPurchasedPrice) {
        return (((double) calculateTotalPrize()) * 100) / totalPurchasedPrice;
    }

    private long calculateTotalPrize() {
        return statistics.keySet()
                .stream()
                .mapToLong(rank -> rank.getPrizeMoney() * statistics.get(rank))
                .sum();
    }

    public Map<Rank, Long> getStatistics() {
        return statistics;
    }
}
