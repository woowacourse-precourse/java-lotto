package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.domain.Rank.*;

public class Statistics {
    private Map<Rank, Integer> rankRecord = new TreeMap<>() {{
        put(FIRST_PLACE, 0);
        put(SECOND_PLACE, 0);
        put(THIRD_PLACE, 0);
        put(FOURTH_PLACE, 0);
        put(FIFTH_PLACE, 0);
        put(UNRANK, 0);
    }};

    private Map<Rank, Integer> rankPrize = new HashMap<>() {{
        put(FIRST_PLACE, 2_000_000_000);
        put(SECOND_PLACE, 30_000_000);
        put(THIRD_PLACE, 1_500_000);
        put(FOURTH_PLACE, 50_000);
        put(FIFTH_PLACE, 5_000);
        put(UNRANK, 0);
    }};

    public void record(Rank rank) {
        rankRecord.put(rank, rankRecord.get(rank) + 1);
    }

    public Map<Rank, Integer> getRankRecord() {
        return rankRecord;
    }

    public String getEarningsRate() {
        return roundToTwoDecimalPlaces();
    }

    private String  roundToTwoDecimalPlaces() {
        return String.format("%.2f", calculateEarningsRate());
    }

    private double calculateEarningsRate() {
        int payment = calculateNumberOfLottosPaid() * LOTTO_PRICE;
        long earnings = calculateEarnings();
        return (double) payment / earnings;
    }

    private int calculateNumberOfLottosPaid() {
        return rankRecord.values().stream()
                .mapToInt(count -> count)
                .sum();
    }

    private long calculateEarnings() {
        long earnings = 0;
        for (Rank rank : rankRecord.keySet()) {
            earnings += (long) rankRecord.get(rank) * rankPrize.get(rank);
        }
        return earnings;
    }
}
