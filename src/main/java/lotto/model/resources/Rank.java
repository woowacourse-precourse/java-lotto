package lotto.model.resources;

import java.util.Map;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public enum Rank {

    FIRST(6, false, 0, 2000000000L),
    SECOND(5, true, 1, 30000000L),
    THIRD(5, false, 2, 1500000L),
    FOURTH(4, false, 3,50000L),
    FIFTH(3, false, 4, 5000L);

    private final int match;
    private final boolean bonus;
    private final int index;
    private final long price;

    Rank(int match, boolean bonus, int index, long price) {
        this.match = match;
        this.bonus = bonus;
        this.index = index;
        this.price = price;
    }

    public static void addWinners(Map<Integer, Integer> lottoResult, AtomicInteger countWin, AtomicBoolean bonus) {
        for (Rank rank : Rank.values()) {
            if (rank.bonus == bonus.get() && rank.match == countWin.get()) {
                lottoResult.put(rank.index, lottoResult.get(rank.index) + 1);
            }
        }
    }

    public static long getPrice(int index) {
        for (Rank rank : Rank.values()) {
            if (rank.index == index) {
                return rank.price;
            }
        }
        return 0;
    }

    public static int getMatch(int index) {
        for (Rank rank : Rank.values()) {
            if (rank.index == index) {
                return rank.match;
            }
        }
        return 0;
    }
}