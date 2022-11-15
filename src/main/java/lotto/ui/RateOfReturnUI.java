package lotto.ui;

public class RateOfReturnUI {
    private static final String MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final double PERCENT_CONSTANT = 100.0;

    public void print(double currentValue, double initialValue) {
        System.out.println(String.format(MESSAGE, currentValue/initialValue * PERCENT_CONSTANT));
    }

}
