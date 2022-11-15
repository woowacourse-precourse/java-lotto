package lotto.domain;

public enum LottoConfig {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    MAX_LENGTH(6),
    THOUSAND(1000);

    private final Integer number;

    LottoConfig(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
