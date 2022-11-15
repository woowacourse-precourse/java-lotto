package lotto;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Statistic {
    private final Map<Prize, Long> prizeTable;
    private final double totalAmountPerOriginalAmount;

    private Statistic(
            Map<Prize, Long> prizeTable,
            double totalAmountPerOriginalAmount
    ) {
        this.prizeTable = prizeTable;
        this.totalAmountPerOriginalAmount = totalAmountPerOriginalAmount;
    }

    public static Statistic of(
            Map<Prize, Long> prizeTable,
            long originalAmount
    ) {
        long totalAmount = prizeTable.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getAmount() * entry.getValue())
                .sum();
        double totalAmountPerOriginalAmount = (0.0F + totalAmount) / originalAmount * 100;

        return new Statistic(sortedPrizeTable(prizeTable), totalAmountPerOriginalAmount);
    }

    private static Map<Prize, Long> sortedPrizeTable(Map<Prize, Long> table) {
        return Stream.of(Prize.FIFTH,
                        Prize.FOURTH,
                        Prize.THIRD,
                        Prize.SECOND,
                        Prize.FIRST)
                .collect(Collectors.toMap(Function.identity(),
                        prize -> table.getOrDefault(prize, 0L),
                        Long::sum,
                        LinkedHashMap::new));
    }

    public Map<Prize, Long> getPrizeTable() {
        return prizeTable;
    }

    public double getTotalAmountPerOriginalAmount() {
        return totalAmountPerOriginalAmount;
    }
}
