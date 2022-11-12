package lotto;

public enum Prize {
    FIRST(2000000000L,"2,000,000,000"),
    SECOND(30000000l,"30,000,000"),
    THIRD(1500000l,"1,500,000"),
    FOURTH(50000l,"50,000"),
    FIFTH(5000l,"5,000");

    private long winMoney;
    private String printWinMoney;
    Prize(long winMoney,String printWinMoney){
        this.winMoney=winMoney;
        this.printWinMoney=printWinMoney;
    }

    public long getWinMoney(){return winMoney;}
    public String getPrintWinMoney(){return printWinMoney;}
}
