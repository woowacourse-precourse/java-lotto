package lotto;

public enum Numbers {
    NOTHING(0),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int count;

    Numbers(int count) {
        this.count = count;
    }
}
