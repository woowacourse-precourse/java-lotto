package lotto.price;

public enum Const {
    LOTTO_TICKET_PRICE(1000);

    private final int value;

    Const(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
