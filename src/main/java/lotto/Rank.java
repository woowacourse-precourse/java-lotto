package lotto;

public enum Rank {
    FIRST(1, 2000000000),
    SECOND(2,30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000);

    private final int ranking;
    private final long money;

    Rank(int ranking, long money) {
        this.ranking = ranking;
        this.money = money;
    }

    public int ranking(){
        return ranking;
    }

    public long money() {
        return money;
    }
}
