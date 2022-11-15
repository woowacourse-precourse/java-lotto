package lotto;

public enum PrizeList {
    FIRST(2000000000, 6, 1,0), SECOND(30000000, 7, 2,1), THIRD(1500000, 5 , 3,0), FOURTH(50000, 4, 4,0), FIFTH(5000, 3, 5,0);
    private final int money;
    private final int matchedNumbers;
    private final int rank;

    private final int bonus;

    PrizeList(int money, int matchedNumbers, int rank, int bonus) {
        this.money = money;
        this.matchedNumbers = matchedNumbers;
        this.rank = rank;
        this.bonus = bonus;
    }

    public int money() {
        return money;
    }

    public int matchedNumbers() {
        return matchedNumbers;
    }

    public int rank() {
        return rank;
    }

    public int bonus(){
        return bonus;
    }
}
