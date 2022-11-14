package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    FIFTH_RANK(3, Bonus.FALSE, "5,000원", 5000),
    FOURTH_RANK(4, Bonus.FALSE, "50,000원", 50000),
    THIRD_RANK(5, Bonus.FALSE, "1,500,000원", 1500000),
    SECOND_RANK(5, Bonus.TRUE, "30,000,000원", 30000000),
    FIRST_RANK(6, Bonus.FALSE, "2,000,000,000원", 2000000000),
    NOT_WINNER(-1, Bonus.FALSE, "0", 0);

    private final int matchedNumber;
    private final Bonus bonus;
    private final String price;
    private int priceAmount;

    Rank(int matchedNumber, Bonus bonus, String price, int priceAmount){
        this.matchedNumber = matchedNumber;
        this.bonus = bonus;
        this.price = price;
        this.priceAmount = priceAmount;
    }

    public static Rank getRank(int matchedNumber, Bonus bonus){
        return Arrays.stream(Rank.values())
                .filter( it -> (it.matchedNumber == matchedNumber)
                                    && it.bonus == bonus)
                .findFirst()
                .orElse(NOT_WINNER);
    }

    public static List<Rank> rankFormatter(){
        return Arrays.stream(Rank.values())
                .collect(Collectors.toUnmodifiableList());
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public String getPrice() {
        return price;
    }

    public Boolean isNeedBonus() {
        return bonus == Bonus.TRUE;
    }

    public int getPriceAmount(){
        return priceAmount;
    }
}
