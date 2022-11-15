package lotto.domain;

public enum Number {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    ZERO(0),
    ONE(1),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    THOUSAND(1000);

    private int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
