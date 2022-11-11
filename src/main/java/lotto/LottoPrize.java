package lotto;

public enum LottoPrize {
    FIRST("6개 일치",2000000000),
    SECOND("5개 일치, 보너스 볼 일치",300000000),
    THIRD("5개 일치",1500000),
    FOURTH("4개 일치",50000),
    FIFTH("3개 일치",5000),
    NONE("낙첨", 0);

    private int lottoPrizeMoney;
    private String matches;

    LottoPrize(String matches, int prizeMoney)
    {
        this.matches = matches;
        this.lottoPrizeMoney = prizeMoney;
    }
}
