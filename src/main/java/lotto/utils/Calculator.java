package lotto.utils;

public class Calculator {
    private final static int MONEY_CELL = 1000;

    private Calculator() {}

    public static int calculateNumberOfLotto(int money) {
        return money / MONEY_CELL;
    }
}
