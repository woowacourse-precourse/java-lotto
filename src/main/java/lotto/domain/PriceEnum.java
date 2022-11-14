package lotto.domain;

public enum PriceEnum {

    LOTTO_PRICE(1000);

    private final int value;

    PriceEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
