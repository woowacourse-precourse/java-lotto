package lotto.domain;

import java.util.Arrays;

public enum Rank {

    None(0, 0),
    Five(3, 5000),
    Four(4, 50_000),
    Three(5, 1_500_000),
    Two(5, 3_000_000),
    One(6, 2_000_000_000);

    private final int matchNumbers;
    private final int prize;

    Rank(int matchNumbers, int prize) {
        this.matchNumbers = matchNumbers;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            if (matchBonus) {
                return Rank.Two;
            }
            return Rank.Three;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.getMatchNumbers() == matchCount)
                .findFirst()
                .orElse(None);
    }

    public int getMatchNumbers() {
        return this.matchNumbers;
    }

    public int getPrize() {
        return this.prize;
    }
}