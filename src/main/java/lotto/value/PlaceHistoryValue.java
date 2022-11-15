package lotto.value;

public enum PlaceHistoryValue {
    ONCE(1),
    INIT_VALUE(0);

    private final int value;

    PlaceHistoryValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
