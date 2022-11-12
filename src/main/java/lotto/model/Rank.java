package lotto.model;

public enum Rank {

    FIRST_RANK(6, Bonus.FALSE, 2000000000),
    SECOND_RANK(5, Bonus.TRUE, 30000000),
    THIRD_RANK(5, Bonus.FALSE, 1500000),
    FOURTH_RANK(4, Bonus.FALSE, 50000),
    FIFTH_RANK(3, Bonus.FALSE, 5000);

    private int matchedNumber;
    private Bonus bonus;
    private int price;

    Rank(int matchedNumber, Bonus bonus, int price){
        this.matchedNumber = matchedNumber;
        this.bonus = bonus;
        this.price = price;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getPrice() {
        return price;
    }

    public Boolean isNeedBonus() {
        return bonus == Bonus.TRUE;
    }
}
