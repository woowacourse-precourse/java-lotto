package lotto.model;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5000L),
    FOURTH(4, 50000L),
    THIRD(5, 1500000L),
    SECOND(5, 30000000L) {
        @Override
        public String toString() {
            return getMatchingState() + BONUS_MATCHING_STATE + getPriceState();
        }
    },
    FIRST(6, 2000000000L),
    NOTHING(0, 0L);

    private static final String MATCHING_STATE = "%d개 일치";
    private static final String BONUS_MATCHING_STATE = ", 보너스 볼 일치";
    private static final String PRICE_STATE = " (%s원)";
    private final int matchingNumber;
    private final long price;

    Rank(int matchingNumber, long price) {
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

    public long computePrice(int numberOfWinningLotto) {
        return price * numberOfWinningLotto;
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
