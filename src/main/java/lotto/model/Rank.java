package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6,2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    NOTHING(0,0);

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
}
