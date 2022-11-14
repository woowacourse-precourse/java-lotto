package lotto;

import java.util.Map;

public enum Match {

    THREE(5000),
    FOUR(50_000),
    FIVE(1_500_000),
    SIX(2_000_000_000),
    FIVE_WITH_BONUS(30_000_000),
    NONE(0);

    private int price;

    private static final Map<Integer, Match> MAP = Map.of(
            3, THREE,
            4, FOUR,
            5, FIVE,
            6, SIX
    );

    Match(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static Match getMatch(int countOfWinNumbers, boolean isBonusNumber) {
        if (countOfWinNumbers == 5 && isBonusNumber == true) {
            return FIVE_WITH_BONUS;
        }

        return MAP.getOrDefault(countOfWinNumbers, NONE);
    }
}
