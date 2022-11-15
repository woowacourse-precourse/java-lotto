package lotto;

public enum Ranking {

    FIFTH(3, "5,000", false),
    FOURTH(4, "50,000", false),
    THRID(5, "1,500,000", false),
    SECOND(5, "30,000,000", true),
    FIRST(6, "2,000,000,000", false);

    private final int match;
    private final String money;
    private final boolean bonusStatus;


    private Ranking(int match, String money, boolean bonusStatus) {
        this.match = match;
        this.money = money;
        this.bonusStatus = bonusStatus;
    }

    public int getMatch() {
        return match;
    }

    public String getMoney() {
        return money;
    }

    public boolean isBonusStatus() {
        return bonusStatus;
    }
}
