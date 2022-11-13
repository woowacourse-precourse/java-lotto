package lotto;

public enum Rank {
    FIFTH(5000)     { double getPrizeMoney(int count) { return count * RANK_MONEY; }},
    FOURTH(50000)    { double getPrizeMoney(int count) { return count * RANK_MONEY; }},
    THIRD(1500000)  { double getPrizeMoney(int count) { return count * RANK_MONEY; }},
    SECOND(30000000) { double getPrizeMoney(int count) { return count * RANK_MONEY; }},
    FIRST(2000000000) { double getPrizeMoney(int count) { return count * RANK_MONEY; }};

    protected final double RANK_MONEY;

    Rank(double rankMoney) {
        RANK_MONEY = rankMoney;
    }

    public double getRankMoney() {
        return RANK_MONEY;
    }

    abstract double getPrizeMoney(int count);
}
