package lotto.domain;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false,1_500_000),
    FOURTH(4, false,50_000),
    FIFTH(3, false,5_000),
    NO_RANK(0, false, 0);

    final private int count;
    final private boolean isBonus;
    final private long prize;

    Rank(int count, boolean isBonus, long prize){
        this.count = count;
        this.isBonus = isBonus;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public boolean getIsBonus() {
        return isBonus;
    }

    public long getPrize(){
        return prize;
    }
}
