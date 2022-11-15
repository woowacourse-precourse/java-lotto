package lotto;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public enum PrizeDetails {
    NOT_THING(0),
    ONE_PRIZE(0),
    TWO_PRIZE(0),
    THREE_PRIZE(5000),
    FOUR_PRIZE(50000),
    FIVE_PRIZE(1500000),
    SIX_PRIZE(2000000000),
    FIVE_PRIZE_AND_BONUS(3000000);

    private Integer price;

    private static final PrizeDetails[] values = PrizeDetails.values();

    PrizeDetails(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return this.price;
    }

    public boolean hasNext() {
        return this.ordinal() < 6;
    }

    public PrizeDetails next() {
        if (hasNext()) {
            return values[this.ordinal() + 1];
        }
        return this;
    }
}