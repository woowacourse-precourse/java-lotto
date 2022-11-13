package lotto.domain;

public enum LottoResult {
    FIRST_PLACE(2000000000),
    SECOND_PLACE(30000000),
    THIRD_PLACE(1500000),
    FOURTH_PLACE(50000),
    FIFTH_PLACE(5000),
    LAST_PLACE(0);

    private final int amount;

    LottoResult(int amount) {
        this.amount = amount;
    }

    public static LottoResult of(int matchingCount, boolean containsBonusNumber) {
        if (matchingCount == 6) {
            return FIRST_PLACE;
        }
        if (matchingCount == 5) {
            if (containsBonusNumber) {
                return SECOND_PLACE;
            }
            return THIRD_PLACE;
        }
        if (matchingCount == 4) {
            return FOURTH_PLACE;
        }
        if (matchingCount == 3) {
            return FIFTH_PLACE;
        }
        return LAST_PLACE;
    }

    public int getAmount() {
        return amount;
    }
}
