package lotto.data;

public enum Rank {
    RANK1(1, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    RANK2( 2, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK3( 3, 1_500_000, "5개 일치 (1,500,000원)"),
    RANK4( 4, 50_000,"4개 일치 (50,000원)"),
    RANK5( 5, 5_000,"3개 일치 (5,000원)"),
    RANK_NONE( 6,0,"꽝"),
    ;

    private final int rank;
    private final int money;
    private final String label;

    Rank(int rank, int money, String label) {
        this.rank = rank;
        this.money = money;
        this.label = label;
    }

    public static Rank getPrize(int match, boolean bonusMatch) {
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

    public String getLabel() {
        return label;
    }
}