package lotto.Domain;

public enum WinningPrize {
    SIX(2000000000),
    FIVEWITHBONUS(30000000),
    FIVE(1500000),
    FOUR(50000),
    THREE(5000);

    private final int winningRank;
    WinningPrize(int winningRank){
        this.winningRank = winningRank;
    }
    public int getPrize(){ return winningRank;}
}
