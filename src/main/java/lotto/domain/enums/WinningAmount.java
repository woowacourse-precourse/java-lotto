package lotto.domain.enums;

public enum WinningAmount {
    LIKE_THREE(5000,"3개 일치 (5,000원)"),
    LIKE_FOUR(50000,"4개 일치 (50,000원)"),
    LIKE_FIVE(1500000,"5개 일치 (1,500,000원)"),
    LIKE_FIVE_AND_BONUS(30000000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    LIKE_SIX(200000000,"6개 일치 (2,000,000,000원)");

    private int prizeMoney;
    private String prizeMessage;

    WinningAmount(int prizeMoney, String prizeMessage) {
        this.prizeMoney = prizeMoney;
        this.prizeMessage = prizeMessage;
    }

    public int getPrizeMoney(){
        return prizeMoney;
    }
    public String getPrizeMessage(){
        return prizeMessage;
    }
}
