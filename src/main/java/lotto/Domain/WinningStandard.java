package lotto.Domain;

public enum WinningStandard {
    FIRST("1등", 2000000000),
    SECOND("2등",30000000),
    THRID("3등",1500000),
    FIRTH("4등",50000),
    FIFTH("5등",5000);

    private String rank;
    private int prizeMoney;

    WinningStandard(String rank, int prizeMoney) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
    public String getRank() {
        return rank;
    }
}
