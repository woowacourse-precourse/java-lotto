package lotto.domain;

public enum Ranking {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    private int count;
    private int money;
    private boolean hasBonusNumber;

    Ranking(int count, int money, boolean hasBonusNumber) {
        this.count = count;
        this.money = money;
        this.hasBonusNumber = hasBonusNumber;
    }
}
