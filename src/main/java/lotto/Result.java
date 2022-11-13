package lotto;

public enum Result {
    FIRST(2000000000, "6개 일치"),
    SECOND(30000000,"5개 일치, 보너스 볼 일치"),
    THIRD(1500000, "5개 일치"),
    FOURTH(50000, "4개 일치"),
    FIFTH(5000,"3개 일치");

    private final int prize;
    private final String standard;

    Result(int intPrize, String standard) {
        this.prize = intPrize;
        this.standard = standard;
    }

    public int getPrize() {
        return prize;
    }
    public String getStandard() {
        return standard;
    }

}
