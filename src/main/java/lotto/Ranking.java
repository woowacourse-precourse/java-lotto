package lotto;

public enum Ranking {
    NOTHING(0, 0L),
    THREE_MATCH(3, 5_000L),
    FOUR_MATCH(4, 50_000L),
    FIVE_MATCH(5, 1_500_000L),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000L),
    SIX_MATCH(6, 2_000_000_000L);

    private int countOfMatch;
    private long winningMoney;

    private Ranking(int countOfMatch, long winningMoney){
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch(){
        return countOfMatch;
    }

    public long getWinningMoney(){
        return winningMoney;
    }
}
