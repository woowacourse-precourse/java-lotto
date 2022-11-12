package lotto.type;

public enum RankType {

    FIRST(200000000, "1등", "6개 일치"),
    SECOND(30000000, "2등", "5개 일치, 보너스 볼 일치"),
    THIRD(1500000, "3등", "5개 일치"),
    FOURTH(50000, "4등", "4개 일치"),
    FIFTH(5000, "5등", "3개 일치");

    private int prizeMoney;
    private String rank;
    private String result;

    RankType(int prizeMoney, String rank, String result) {
        this.prizeMoney = prizeMoney;
        this.rank = rank;
        this.result = result;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public String getRank() {
        return rank;
    }

    public String getResult() {
        return result;
    }
}
