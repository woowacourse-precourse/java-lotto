package lotto.domain;

public enum WinningResult {
    MATCH_THREE(3),
    MATCH_FOUR(4),
    MATCH_FIVE(5),
    MATCH_SIX(6);

    private int value;

    WinningResult(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
