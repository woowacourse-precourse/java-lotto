package lotto.domain;

import java.util.EnumMap;

public class History {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int HUNDRED = 100;
    public static final int THOUSAND = 1000;
    public static final String NUMBER = "개";

    private EnumMap<Result, Integer> history;

    History() {
        history = new EnumMap<>(Result.class);
        for (Result result : Result.values()) {
            history.put(result,ZERO);
        }
    }
    public static History newInstance() {
        return new History();
    }

    public void report(Result result) {
        history.put(result, history.get(result) + ONE);
    }

    public String calculateProfitRate() {
        double totalPurchase = calculateTotalPurchase();
        double totalProfit = calculateTotalProfit();
        return String.format("%.1f",totalProfit/totalPurchase * HUNDRED);
    }

    private double calculateTotalProfit() {
        double totalProfit = history.keySet().stream()
                .mapToDouble(result -> result.calculateProfit(history.get(result)))
                .sum();
        return totalProfit;
    }

    private double calculateTotalPurchase() {
        double totalPurchase = history.values().stream()
                .reduce(ZERO, Integer::sum) * THOUSAND;
        return totalPurchase;
    }
    public String showNumber(Result result) {
        return history.get(result) + NUMBER;
    }
}
