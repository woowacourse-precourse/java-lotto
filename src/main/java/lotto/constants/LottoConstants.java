package lotto.constants;

public enum LottoConstants {
    START_NUMBER(1),
    END_NUMBER(45),
    LENGTH(6),
    TICKET_PRICE(1000);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
