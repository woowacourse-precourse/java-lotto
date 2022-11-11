package lotto;

public enum LottoPrizes {
    FIRST(1, "1st"),
    SECOND(2, "2nd"),
    THIRD(3, "3rd"),
    FOURTH(4,"4th"),
    FIFTH(5,"5th"),
    NOTHING(0, "nothing");
    private final int indexNumber;
    private final String keyName;
    LottoPrizes(int indexNumber, String keyName) {
        this.indexNumber = indexNumber;
        this.keyName = keyName;
    }
    public static LottoPrizes prizes(int condition, boolean hasBonus) {
        if (condition == 6) {
            return FIRST;
        }
        if (condition == 5 && hasBonus) {
            return SECOND;
        }
        if (condition == 5) {
            return THIRD;
        }
        if (condition == 4) {
            return FOURTH;
        }
        if (condition == 3) {
            return FIFTH;
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
