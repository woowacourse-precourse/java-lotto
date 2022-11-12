package lotto.model;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Rank {
    FIRST(6,2000000000),
    SECOND(5,30000000){
        @Override
        public String toString() {
            return getMatchingState() + BONUS_MATCHING_STATE + getPriceState();
        }
    },
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    NOTHING(0,0);

    private static final String MATCHING_STATE = "%d개 일치";
    private static final String BONUS_MATCHING_STATE = ", 보너스 볼 일치";
    private static final String PRICE_STATE = " (%s원)";
    private final int matchingNumber;
    private final int price;

    Rank(int matchingNumber, int price) {
        this.matchingNumber = matchingNumber;
        this.price = price;
    }

    public static Rank of(int matchingNumber, boolean hasBonusNumber) {
        if (matchingNumber == 5 && hasBonusNumber) {
            return Rank.SECOND;
        }
        if (matchingNumber == 5) {
            return Rank.THIRD;
        }

        return Arrays.stream(values())
                .filter(value -> value.matchingNumber == matchingNumber)
                .findFirst()
                .orElse(Rank.NOTHING);
    }

    @Override
    public String toString() {
        return getMatchingState() + getPriceState();
    }

    protected String getMatchingState() {
        return String.format(MATCHING_STATE, matchingNumber);
    }

    protected String getPriceState() {
        DecimalFormat df = new DecimalFormat("###,###");
        return String.format(PRICE_STATE, df.format(price));
    }
}
