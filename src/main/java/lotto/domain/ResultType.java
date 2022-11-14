package lotto.domain;

public enum ResultType {
    THREE("3개 일치 (5,000원)",5000),
    FOUR("4개 일치 (50,000원)",50000),
    FIVE("5개 일치 (1,500,000원)",1500000),
    FIVEPLUS("5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
    SIX("6개 일치 (2,000,000,000원)",2000000000),
    NOWINNING("당첨되지 않았습니다.",0)
    ;

    final private String detail;
    final private int winnings;


    ResultType(String detail, int winnings) {
        this.detail = detail;
        this.winnings = winnings;
    }

    public String getDetail(){
        return detail;
    }
    public int getWinnings(){
        return winnings;
    }
}
