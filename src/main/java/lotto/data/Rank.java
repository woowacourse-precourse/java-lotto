package lotto.data;

public enum Rank {
    RANK1(1, 2_000_000_000),
    RANK2( 2, 30_000_000),
    RANK3( 3, 1_500_000),
    RANK4( 4, 50_000),
    RANK5( 5, 5_000),
    RANK_NONE( 6,0),
    ;

    private final int rank;
    private final int money;

    Rank(int rank, int money) {
        this.rank = rank;
        this.money = money;
    }

    public static Rank getRank(int match, boolean bonusMatch) {
        if(match == 6) return RANK1;
        else if(match == 5 && bonusMatch) return RANK2;
        else if(match == 5) return RANK3;
        else if(match == 4) return RANK4;
        else if(match == 3) return RANK5;
        return RANK_NONE;
    }

    public int getMoney() {
        return money;
    }
    public int getRank() {
        return rank;
    }
}