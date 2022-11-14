package lotto.Model;

import java.util.Arrays;

public enum Rank {
    LOSING_TICKET(0, 0, 0),
    THREE(3, 0, 5_000),
    FOUR(4, 0, 50_000),
    FIVE(5, 0, 1_500_000),
    BONUS(5, 1, 30_000_000),
    SIX(6, 0, 2_000_000_000);

    private final int count;
    private final int bonus;
    private final int prizeMoney;


    Rank(int count, int bonus, int prizeMoney) {
        this.count = count;
        this.bonus = bonus;
        this.prizeMoney = prizeMoney;
    }

    public static Rank getRank(int count, int bonus) {
        if (count < 3) {
            return LOSING_TICKET;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.count == count)
                .filter(rank -> rank.bonus == bonus)
                .findFirst().get();
    }

    public int getCount() {
        return count;
    }

    public int getBonus(int count) {
        return bonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}