package lotto;

public enum Grade {
    FIFTH(3, 5000, ""),
    FOURTH(4, 50000, ""),
    THIRD(5, 1500000, ""),
    SECOND(5, 30000000, ", 보너스 볼 일치"),
    FIRST(6, 2000000000, "");

    private final int matchNumber;
    private final int price;
    private final String bonusBall;

    private Grade(int matchNumber, int price, String bonusBall) {
        this.matchNumber = matchNumber;
        this.price = price;
        this.bonusBall = bonusBall;
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public int getPrice() {
        return this.price;
    }

    public String getBonusBall() {
        return this.bonusBall;
    }
}
