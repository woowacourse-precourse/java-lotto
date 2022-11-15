package lotto.domain.info;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    EXTERIOR(0,false, 0);

    private final int count;
    private final boolean bonus;
    private final int price;

    Rank(int count, boolean bonus, int price) {
        this.count = count;
        this.bonus = bonus;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonus() {
        return bonus;
    }

    public static Rank getRank(int count, boolean bonus) {
        Rank lottoRank = Arrays.stream(Rank.values()).filter(rank -> rank.count > 0)
                .filter(rank -> rank.count == count).findFirst().orElse(EXTERIOR);
        if (count == 5 && !bonus) {
            return THIRD;
        }
        return lottoRank;
    }
}
