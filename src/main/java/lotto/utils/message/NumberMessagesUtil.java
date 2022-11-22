package lotto.utils.message;

public enum NumberMessagesUtil {
    LOTTO_MIN(1),
    LOTTO_MAX(45),
    LOTTO_COUNT(6),
    LOTTO_PRICE(1000),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3);

    private final int number;

    NumberMessagesUtil(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
