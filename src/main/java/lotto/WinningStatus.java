package lotto;

public enum WinningStatus {
    CASE1(3,5000,"3개 일치 (5,000원) - "),
    CASE2(4,50_000,"4개 일치 (50,000원) - "),
    CASE3(5,1_500_000,"5개 일치 (1,500,000원) - "),
    CASE4(7,30_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    CASE5(6,2_000_000_000,"6개 일치 (2,000,000,000원) - ");

    private int matchNumber;
    private int winningPrice;
    private String format;

    WinningStatus(int matchNumber, int winningPrice, String statisticsFormat){
        this.matchNumber = matchNumber;
        this.winningPrice = winningPrice;
        this.format = statisticsFormat;
    }

    public int getMatchNumber(){
        return matchNumber;
    }

    public int getWinningPrice(){
        return winningPrice;
    }

    public String getFormat(){
        return format;
    }

}
