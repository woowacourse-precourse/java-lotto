package lotto;

public enum Prize {
    FIFTH_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    THIRD_PLACE(5, 1_500_000),
    SECOND_PLACE(5, 30_000_000),
    FIRST_PLACE(6,2_000_000_000);
    private int winning, prizeMoney;
    private boolean bonus;
    Prize(int winning, int prizeMoney) {
        this.winning = winning;
        this.prizeMoney = prizeMoney;
    }

    public int getWinning() {
        return winning;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
