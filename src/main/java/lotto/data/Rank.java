package lotto.data;

public enum Rank {
    RANK1("6개 일치 (2,000,000,000원)", 1),
    RANK2("5개 일치, 보너스 볼 일치 (30,000,000원)", 2),
    RANK3("5개 일치 (1,500,000원)", 3),
    RANK4("4개 일치 (50,000원)", 4),
    RANK5("3개 일치 (5,000원)", 5),
    RANK_NONE("꽝", 6),
    ;

    private final String label;
    private final int rank;

    Rank(String label, int rank) {
        this.label = label;
        this.rank = rank;
    }

    public static Rank getRank(int match, boolean bonusMatch) {
        if(match == 6) return RANK1;
        else if(match == 5 && bonusMatch) return RANK2;
        else if(match == 5) return RANK3;
        else if(match == 4) return RANK4;
        else if(match == 3) return RANK5;
        return RANK_NONE;
    }

    public String getLabel() {
        return label;
    }
    public int getRank() {
        return rank;
    }
}