package lotto;

public class Exception {

    public void isNotIntegerException() {
        throw new IllegalArgumentException("[ERROR]: not integer exception");
    }

    public void isMoneyUnitException() {
        throw new IllegalArgumentException("[ERROR]: payment amount exception");
    }
}
