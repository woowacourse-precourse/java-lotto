package lotto.model;

import java.util.Arrays;

public enum Rank {

    FIRST_RANK(6, Bonus.FALSE, 2000000000),
    SECOND_RANK(5, Bonus.TRUE, 30000000),
    THIRD_RANK(5, Bonus.FALSE, 1500000),
    FOURTH_RANK(4, Bonus.FALSE, 50000),
    FIFTH_RANK(3, Bonus.FALSE, 5000),
    NOT_WINNER(-1, Bonus.FALSE, 0);

    private int matchedNumber;
    private Bonus bonus;
    private int price;

    Rank(int matchedNumber, Bonus bonus, int price){
        this.matchedNumber = matchedNumber;
        this.bonus = bonus;
        this.price = price;
    }

    public static Rank getRank(int matchedNumber, Bonus bonus){
        return Arrays.stream(Rank.values())
                .filter( it -> (it.matchedNumber == matchedNumber)
                                    && it.bonus == bonus)
                .findFirst()
                .orElse(NOT_WINNER);
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
