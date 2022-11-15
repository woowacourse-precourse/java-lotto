package lotto;

public enum Rank {
    NO_PRIZE(0, 0, false),
    FIFTH(5000, 3, false),
    FOURTH(50000, 4, false),
    THIRD(1500000, 5, false),
    SECOND(30000000, 5, true),
    FIRST(2000000000, 6, false);

    private final int prizeMoney;
    private final int hitCount;
    private final boolean hitBonus;

    private Rank(int prizeMoney, int hitCount, boolean hitBonus){
        this.prizeMoney = prizeMoney;
        this.hitCount = hitCount;
        this.hitBonus = hitBonus;
    }

    // need Refactor
    // TODO: hitCount 와 hitBonus 를 비교하여 RANK를 반환한다.
    public static Rank valueOf(int hitCount, boolean hitBonus){
        if (FIFTH.hitCount > hitCount)
            return NO_PRIZE;
        if (SECOND.matchCount(hitCount) && hitBonus)
            return SECOND;
        if (THIRD.matchCount(hitCount) && !hitBonus)
            return THIRD;

        for (Rank rank : values()){
            if (rank.matchCount(hitCount)) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }


    private boolean matchCount(int hitCount){
        return this.hitCount == hitCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getHitCount() {
        return hitCount;
    }

    public boolean getHitBonus() {
        return hitBonus;
    }
}
