package lotto.enums;

public enum RankMoney {
    FIRST_PRIZE_MONEY(2000000000), SECOND_PRIZE_MONEY(30000000), THIRD_PRIZE_MONEY(15000000), FOURTH_PRIZE_MONEY(50000), FIFTH_PRIZE_MONEY(5000);

    private int prizeMoney;

    RankMoney(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
