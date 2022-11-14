package lotto;

public enum WinningStatus {
    CASE1(3,5000),
    CASE2(4,50_000),
    CASE3(5,1_500_000),
    CASE4(7,30_000_000),
    CASE5(6,2_000_000_000);

    private int matchNumber;
    private int winningPrice;

    WinningStatus(int matchNumber, int winningPrice){
        this.matchNumber = matchNumber;
        this.winningPrice = winningPrice;
    }

    public int getMatchNumber(){
        return matchNumber;
    }

    public int getWinningPrice(){
        return winningPrice;
    }

    public void winningStatistics(){

    }
}
