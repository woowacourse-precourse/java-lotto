package lotto.util;

public enum Statistic {
    SAME_SIX(6), SAME_FIVE_BONUS(5), SAME_FIVE(5), SAME_FOUR(4), SAME_THREE(3),
    SIX_PRICE(2000000000), FIVE_BONUS_PRICE(30000000), FIVE_PRICE(1500000),
    FOUR_PRICE(50000), THREE_PRICE(5000);

    private final int value;
    Statistic(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
