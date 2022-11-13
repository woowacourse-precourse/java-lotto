package lotto.model.statistics;

public enum LottoResult {
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000),
    MISS(0, 0, false, 0)
    ;

    private final int grade;
    private final int matchCount;
    private final boolean doesMatchBonusBall;
    private final int prize;

    LottoResult(
            int grade,
            int matchCount,
            boolean doesMatchBonusBall,
            int prize
    ) {
        this.grade = grade;
        this.matchCount = matchCount;
        this.doesMatchBonusBall = doesMatchBonusBall;
        this.prize = prize;
    }

    public int getPrize() {
        // TODO 구현 필요
        return 0;
    }

    public String getDescription() {
        // TODO 구현 필요
        return "3개 일치 (5,000원)";
    }
}
