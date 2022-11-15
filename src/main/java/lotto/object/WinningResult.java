package lotto.object;

public enum WinningResult {
    SIX_MATCH(2000000000, 6, "6개 일치"),
    FIVE_AND_BONUS_MATCH(30000000, -1, "5개 일치, 보너스 볼 일치"),
    FIVE_MATCH(1500000, 5, "5개 일치"),
    FOUR_MATCH(50000, 4, "4개 일치"),
    THREE_MATCH(5000, 3, "3개 일치");

    public static final Integer MAX_MATCH = 6;

    private final Integer prize;
    private final Integer matchNumber;
    private final String condition;

    WinningResult(Integer prize, Integer matchNumber, String condition) {
        this.prize = prize;
        this.matchNumber = matchNumber;
        this.condition = condition;
    }

    public Integer getPrize() {
        return prize;
    }

    public Integer getMatchNumber() {
        return matchNumber;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(condition);
        sb.append(String.format(" (%,d원)", prize));

        return sb.toString();
    }
}
