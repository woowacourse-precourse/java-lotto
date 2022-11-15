package lotto.domain;

public enum LottoRank {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH_AND_BONUS_MATCH(7, 30_000_000),
    FIVE_MATCH(5, 1_500_000),
    SIX_MATCH(6, 2_000_000_000),
    MISS_MATCH(0, 0);
    private int money;
    private int count;

    LottoRank(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public int getCount() {
        return this.count;
    }

    public int getMoney() {
        return this.money;
    }
}
