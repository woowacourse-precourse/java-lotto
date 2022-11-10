package lotto;

public enum Rank {
    RANK1("6개 일치 (2,000,000,000원)"),
    RANK2("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK3("5개 일치 (1,500,000원)"),
    RANK4("4개 일치 (50,000원)"),
    RANK5("3개 일치 (5,000원)"),
    RANK_NONE("꽝"),
    ;

    private final String label;

    Rank(String label) {
        this.label = label;
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
}