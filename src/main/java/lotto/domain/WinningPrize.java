package lotto.domain;

public enum WinningPrize {
    FIRST_PLACE(2000000000),
    SECOND_PLACE(30000000),
    THIRD_PLACE(1500000),
    FOURTH_PLACE(50000),
    FIFTH_PLACE(5000),
    LAST_PLACE(0);

    private final int amount;

    WinningPrize(int amount) {
        this.amount = amount;
    }

    public static WinningPrize of(int sameCount, boolean containsBonusNumber) {
        if (sameCount == 6) {
            return FIRST_PLACE;
        }
        if (sameCount == 5) {
            if (containsBonusNumber) {
                return SECOND_PLACE;
            }
            return THIRD_PLACE;
        }
        if (sameCount == 4) {
            return FOURTH_PLACE;
        }
        if (sameCount == 3) {
            return FIFTH_PLACE;
        }
        return LAST_PLACE;
    }
}
