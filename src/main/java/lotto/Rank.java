package lotto;

public enum Rank {

    RANK1(2_000_000_000, 6, false),
    RANK2(30_000_000, 5, true),
    RANK3(1_500_000, 5, false),
    RANK4(50_000, 4, false),
    RANK5(5_000, 3, false),
    NOTHING(0, 0, false);

    private final long prize;
    private final int match;
    private final boolean isBonus;

    Rank(int prize, int match, boolean isBonus) {
        this.prize = prize;
        this.match = match;
        this.isBonus = isBonus;
    }

    public static Rank getRanking(int match, boolean isBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.match == match && rank.isBonus == isBonus) {
                return rank;
            }
        }
        return NOTHING;
    }

    public long getPrize() {
        return prize;
    }
}
