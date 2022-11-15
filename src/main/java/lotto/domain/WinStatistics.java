package lotto.domain;

public class WinStatistics {
    private final Rank rank;
    private final EarningRate earnRate;


    public WinStatistics(Rank rank, EarningRate earnRate) {
        this.rank = rank;
        this.earnRate = earnRate;
    }


}
