package lotto.domain.constant;

public enum LottoProperty {
    LENGTH(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    PRICE(1000),
    MIN_WINNING_MATCHES(3);

    private final int property;

    private LottoProperty (int property) {
        this.property = property;
    }

    public int getProperty() {
        return property;
    }
}
