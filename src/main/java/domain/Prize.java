package domain;

public enum Prize {
    firstPrize(1, 2000000000),
    secondPrice(2, 30000000),
    thirdPrice(3, 1500000),
    fourthPrice(4, 50000),
    fifthPrice(5, 5000);

    public final int ranking;
    public final int rankingPrize;

    private Prize(int ranking, int rankingPrize) {
        this.ranking = ranking;
        this.rankingPrize = rankingPrize;
    }

}
