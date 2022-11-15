package lotto.domain;

public enum LottoCondition {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    COUNT(6),
    PRICE(1000);

    private final int number;

    LottoCondition(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
