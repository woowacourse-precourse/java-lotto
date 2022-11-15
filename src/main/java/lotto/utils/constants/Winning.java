package lotto.utils.constants;

public enum Winning {

    FIRST_PLACE(6, false, 2_000_000_000, 1),
    SECOND_PLACE(5, true, 30_000_000, 2),
    THIRD_PLACE(5, false, 1_500_000, 3),
    FOURTH_PLACE(4, false, 50_000, 4),
    FIFTH_PLACE(3, false, 5_000, 5);

    private final int matchAmount;
    private final boolean matchBonus;
    private final int money;
    private final int rank;

    Winning(final int matchAmount, final boolean matchBonus, final int money, final int rank) {
        this.matchAmount = matchAmount;
        this.matchBonus = matchBonus;
        this.money = money;
        this.rank = rank;
    }

    public int getMoney() {
        return money;
    }

    public int getMatchAmount() {
        return matchAmount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getRank() {
        return rank;
    }

}
