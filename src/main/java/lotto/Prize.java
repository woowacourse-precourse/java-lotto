package lotto;

public enum Prize {




    FIFTH(5000l,"5,000","3개 일치"),
    FOURTH(50000l,"50,000","4개 일치"),
    THIRD(1500000l,"1,500,000","5개 일치"),
    SECOND(30000000l,"30,000,000","5개 일치, 보너스 볼 일치"),
    FIRST(2000000000L,"2,000,000,000","6개 일치");

    private long winMoney;
    private String printWinMoney;
    private String printCondition;
    Prize(long winMoney,String printWinMoney,String printCondition){
        this.winMoney=winMoney;
        this.printWinMoney=printWinMoney;
        this.printCondition=printCondition;
    }

    public long getWinMoney(){return winMoney;}
    public String getPrintWinMoney(){return printWinMoney;}

    public String getPrintCondition(){return printCondition;}
}
