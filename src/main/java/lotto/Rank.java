package lotto;

public enum Rank {

    RANK1(2_000_000_000, 6, false, 0),
    RANK2(30_000_000, 5, true, 1),
    RANK3(1_500_000, 5, false, 2),
    RANK4(50_000, 4, false, 3),
    RANK5(5_000, 3, false, 4),
    NOTHING(0, 0, false, 5);

    private final long prize;
    private final int match;
    private final boolean isBonus;
    private final int index;

    Rank(int prize, int match, boolean isBonus, int index) {
        this.prize = prize;
        this.match = match;
        this.isBonus = isBonus;
        this.index = index;
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

    public int getIndex() {
        return index;
    }
}
