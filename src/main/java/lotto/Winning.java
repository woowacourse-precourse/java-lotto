package lotto;

public enum Winning {
    THREE(5, "(5,000원)", "3개 일치"),
    FOUR(4, "(50,000원)", "4개 일치"),
    FIVE(3, "(1,500,000원)", "5개 일치"),
    FIVE_WITH_BONUS(2, "(30,000,000원)", "5개 일치, 보너스 볼 일치"),
    SIX(1, "(2,000,000,000원)", "6개 일치"),
    NONE(-1, "", "");

    private final String value;
    private final String match;
    private final int rank;

    Winning(int rank, String value, String match) {
        this.value = value;
        this.rank = rank;
        this.match = match;
    }

    public int getRank() {
        return rank;
    }

    public String getValue() {
        return value;
    }

    public String getMatch() {
        return match;
    }
}
