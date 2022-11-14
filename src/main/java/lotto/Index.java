package lotto;

public enum Index {
    PURCHASE_AMOUNT(0),
    PURCHASE_COUNT(1),
    WINNING_NUMBER(2);

    private final int INDEX;

    Index(final int index) {
        INDEX = index;
    }
    public int getIndex() {
        return (INDEX);
    }
}
