package lotto.domain.enums;

public enum LottoRanking {
    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L);

    private final int count;
    private final boolean bonus;
    private final long money;

    LottoRanking(int count, boolean bonus, long money) {
        this.count = count;
        this.bonus = bonus;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonus() {
        return bonus;
    }

    public Long getMoney() {
        return money;
    }
}