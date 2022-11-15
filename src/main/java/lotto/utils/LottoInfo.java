package lotto.utils;

public enum LottoInfo {
    LENGTH(6),
    START_NUMBER(1),
    END_NUMBER(45),
    PRICE(1000);

    private final int number;

    LottoInfo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}