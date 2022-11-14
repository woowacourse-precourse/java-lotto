package lotto;

import java.text.DecimalFormat;

public enum Rank {
    NONE(0, 0), FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000), THIRD(5, 1_500_000),
    FOURTH(4, 50_000), FIFTH(3, 5_000);

    final int winningAmount;
    final int matchCount;

    Rank(int matchCount, int winningAmount){
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public String getDottedWinningAmount(){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(winningAmount);
    }

    public int getWinningAmount(){
        return winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
