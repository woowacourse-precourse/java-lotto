package lotto.domain.number;

import lotto.resource.message.ErrorMessage;

public class PayOut {
    public static final int GAME_PRICE = 1_000;
    private final Number value;

    private PayOut() {
        value = new Number(0);
    }

    public PayOut(Number number) {
        validateNotPositive(number.getValueAsInt());
        validateGamePrice(number.getValueAsInt());
        this.value = number;
    }

    public PayOut(String number) {
        this(new Number(number));
    }

    public PayOut(int number) {
        this(new Number(number));
    }

    public int getGameCount() {
        return value.getValueAsInt() / GAME_PRICE;
    }

    private void validateGamePrice(int value) {
        if (value % GAME_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_THOUSANDS_MESSAGE.getValue());
        }
    }

    private void validateNotPositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_NOT_POSITIVE_MESSAGE.getValue());
        }
    }

    public int getValueAsInt() {
        return value.getValueAsInt();
    }
}
