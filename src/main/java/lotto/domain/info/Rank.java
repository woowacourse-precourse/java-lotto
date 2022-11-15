package lotto.domain.info;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    EXTERIOR(0, 0);

    private final int count;
    private final int price;

    Rank(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getPrice() {
        return price;
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
