package lotto.utils.message;

public enum NumberMessageUtil {
    LOTTO_MIN(1),
    LOTTO_MAX(45),
    LOTTO_COUNT(6),
    LOTTO_PRICE(1000);

    private final int number;

    NumberMessageUtil(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
