package lotto.domain;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String ERROR_MESSAGE = "[ERROR]: 로또 숫자는 %d에서 %d사이의 값이여야 합니다.";

    private final int value;

    public LottoNumber(int value) {
        validateValue(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int getMinNumber() {
        return MIN_NUMBER;
    }

    public static int getMaxNumber() {
        return MAX_NUMBER;
    }

    private void validateValue(int value) {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, MIN_NUMBER, MAX_NUMBER));
        }
    }
}
