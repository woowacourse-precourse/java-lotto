package lotto;

public class Exception {

    public void isNotIntegerException() {
        throw new IllegalArgumentException("[ERROR]: not integer exception");
    }

    public void isMoneyUnitException() {
        throw new IllegalArgumentException("[ERROR]: payment amount exception");
    }

    public void isNotLottoNumberRangeException() {
        throw new IllegalArgumentException("[ERROR]: not in lottery number range");
    }
}
