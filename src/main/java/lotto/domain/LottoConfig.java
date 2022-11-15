package lotto.domain;

public enum LottoConfig {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    MAX_LENGTH(6),
    THOUSAND(1000);

    private final int number;

    LottoConfig(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
