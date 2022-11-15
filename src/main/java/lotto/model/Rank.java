package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.util.Constants;

public enum Rank {
    FIFTH(3, Arrays.asList(true, false), 5_000, 0, Constants.MESSAGE_FIFTH),
    FOURTH(4, Arrays.asList(true, false), 50_000, 0, Constants.MESSAGE_FOURTH),
    THIRD(5, Arrays.asList(false), 1_500_000, 0, Constants.MESSAGE_THIRD),
    SECOND(5, Arrays.asList(true), 30_000_000, 0, Constants.MESSAGE_SECOND),

    FIRST(6, Arrays.asList(true, false), 2_000_000_000, 0, Constants.MESSAGE_FIRST),
    NONE(0, Arrays.asList(true, false), 0, 0, "");

    private final int match;
    private final int cashPrize;
    private final List<Boolean> hasBonus;
    private int count;
    private final String printMessage;

    Rank(int match, List<Boolean> hasBonus, int cashPrize, int count, String printMessage) {
        this.match = match;
        this.hasBonus = hasBonus;
        this.cashPrize = cashPrize;
        this.count = count;
        this.printMessage = printMessage;
    }

    public static void initializeRankCount() {
        for (Rank rank : Rank.values()) {
            rank.count = 0;
        }
    }

    public void addCount(Rank rank) {
        rank.count++;
    }

    public int getMatch() {
        return match;
    }

    public List<Boolean> getHasBonus() {
        return hasBonus;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public int getCount() {
        return count;
    }

    public String getPrintMessage() {
        return printMessage;
    }

}

