package lotto;

public enum LottoPrizes {
    FIRST(1, "1st"),
    SECOND(2, "2nd"),
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
        return NOTHING;
    }
    public int index() {
        return indexNumber;
    }
    public String key() {
        return keyName;
    }

}
