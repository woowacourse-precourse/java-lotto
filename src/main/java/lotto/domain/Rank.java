package lotto.domain;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;


    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank getRankByMatchCount(int matchCount, boolean matchBonus) {
        for (Rank type : Rank.values()) {
            if (type.getMatchCount() == matchCount && type.getMatchBonus() == matchBonus) {
                return type;
            }
        }
        return MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }
}
