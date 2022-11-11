package lotto;

public enum LottoPrizes {
    FIRST(1, "1st", 6),
    SECOND(2, "2nd", 5),
    THIRD(3, "3rd", 5),
    FOURTH(4, "4th", 4),
    FIFTH(5, "5th", 3),
    NOTHING(0, "nothing", -1);
    private final int indexNumber;
    private final String keyName;
    private final int condition;
    LottoPrizes(int indexNumber, String keyName, int condition) {
        this.indexNumber = indexNumber;
        this.keyName = keyName;
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
    public String key() {
        return keyName;
    }
}
