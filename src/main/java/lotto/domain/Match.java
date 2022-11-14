package lotto.domain;

public enum Match {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int match;

    Match(int match) {
        this.match = match;
    }
    public int getMatch() {
        return match;
    }

}
