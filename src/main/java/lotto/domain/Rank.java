package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000,3,false),
    NO(0, 0, false);

    private final int prize;
    private final int count;
    private final boolean hasBonus;

    Rank(int prize, int count, boolean hasBonus) {
        this.prize = prize;
        this.count = count;
        this.hasBonus = hasBonus;
    }

    public Rank getRanking(int count, boolean hasBonus){
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.count == count && rank.hasBonus == hasBonus)
                .findAny()
                .orElse(NO);
    }
}
