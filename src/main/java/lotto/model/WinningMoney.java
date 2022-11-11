package lotto.model;

public enum WinningMoney {
    WINNING_THREE(0),
    WINNING_FOUR(0),
    WINNING_FIVE(0),
    WINNING_FIVE_AND_BONUS(0),
    WINNING_SIX(0);

    private int count;

    WinningMoney(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void countUp() {
        ++count;
    }
}