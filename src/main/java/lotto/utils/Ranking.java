package lotto.utils;

public enum Ranking {
    RANK6(0, false, 0),
    RANK5(3, false, 5_000),
    RANK4(4, false, 50_000),
    RANK3(5, false, 1_500_000),
    RANK2(5, true, 30_000_000),
    RANK1(6, false, 2_000_000_000);

    private final int match;
    private final boolean bonus;
    private final long prize;

    Ranking(int match, boolean bonus, long prize) {
        this.match = match;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static Ranking getRanking(int match, boolean bonus) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.match == match && ranking.bonus == bonus) {
                return ranking;
            }
        }
        return RANK6;
    }

    public long getPrize() {
        return prize;
    }
}