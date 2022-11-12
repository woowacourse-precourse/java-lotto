package lotto.domain;

public class Counter {
    private static final int eachPrice = 1000;

    public static int getQuantity(String input) {
        return Integer.parseInt(input) / eachPrice;
    }
}
