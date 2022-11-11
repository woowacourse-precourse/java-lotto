package lotto;

public enum LottoPrizes {
    FIRST(1, 6),
    SECOND(2, 5),
    THIRD(3, 5),
    FOURTH(4, 4),
    FIFTH(5, 3),
    NOTHING(0, -1);
    private final int indexNumber;
    private final int condition;
    LottoPrizes(int indexNumber, int condition) {
        this.indexNumber = indexNumber;
        this.condition = condition;
    }
    public static LottoPrizes prizes(int condition, boolean hasBonus) {
        if (condition == 5 && hasBonus) {
            return SECOND;
        }
        return prizes(condition);
    }
    public static LottoPrizes prizes(int condition) {
        for (LottoPrizes prize : LottoPrizes.values()) {
            if (prize.equals(SECOND)) {
                continue;
            }
            if (prize.condition == condition) {
                return prize;
            }
        }
        return NOTHING;
    }
    public int index() {
        return indexNumber;
    }
}
