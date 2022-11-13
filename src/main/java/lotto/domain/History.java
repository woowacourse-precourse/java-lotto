package lotto.domain;

import java.util.EnumMap;

public class History {

    private EnumMap<Result, Integer> history;

    History() {
        history = new EnumMap<>(Result.class);
        for (Result result : Result.values()) {
            history.put(result,0);
        }
    }
    public static History newInstance() {
        return new History();
    }

    public void report(Result result) {
        history.put(result, history.get(result) + 1);
    }

    public String calculateProfitRate() {
        double totalPurchase = calculateTotalPurchase();
        double totalProfit = calculateTotalProfit();
        return String.format("%.1f",totalProfit/totalPurchase * 100);
    }

    private double calculateTotalProfit() {
        double totalProfit = history.keySet().stream()
                .mapToDouble(result -> result.calculateProfit(history.get(result)))
                .sum();
        return totalProfit;
    }

    private double calculateTotalPurchase() {
        double totalPurchase = history.values().stream()
                .reduce(0, Integer::sum) * 1000;
        return totalPurchase;
    }
}
