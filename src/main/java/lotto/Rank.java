package lotto;

import java.util.Arrays;
import java.util.List;

public enum Rank {

    LOSING_PRICE(0, 0, false),
    FIFTH_PRICE(5_000, 3, false),
    FOURTH_PRICE(50_000, 4, false),
    THIRD_PRICE(1_500_000, 5, false),
    SECOND_PRICE(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);
    private final int prize;
    private final int match;
    private final boolean bonus;
    Rank(int prize, int match, boolean bonus){
        this.prize = prize;
        this.match = match;
        this.bonus = bonus;
    }

    public static Rank calculateRank(Lotto lotto, List<Integer> winningNumber, Integer bonusNumber){
        int count = (int) lotto.getNumbers().stream().filter(winningNumber::contains).count();
        boolean contains = lotto.getNumbers().contains(bonusNumber);

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.match == count)
                .filter(rank -> rank.bonus == contains)
                .findAny()
                .orElse(LOSING_PRICE);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatch() {
        return match;
    }
}
