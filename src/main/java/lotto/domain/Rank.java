package lotto.domain;

import lotto.util.Constants;

public enum Rank {
    FIFTH(3, 5_000, 0, Constants.MESSAGE_FIFTH),
    FOURTH(4, 50_000, 0, Constants.MESSAGE_FOURTH),
    THIRD(5, 1_500_000, 0, Constants.MESSAGE_THIRD),
    SECOND(5, 30_000_000, 0, Constants.MESSAGE_SECOND),

    FIRST(6, 2_000_000_000, 0, Constants.MESSAGE_FIRST),
    NONE(0, 0, 0, "");

    private final int match;
    private final int cashPrize;
    private int count;
    private final String printMessage;

    Rank(int match, int cashPrize, int count, String printMessage) {
        this.match = match;
        this.cashPrize = cashPrize;
        this.count = count;
        this.printMessage = printMessage;
    }

    public void addCount(Rank rank) {
        rank.count++;
    }

    public int getMatch() {
        return match;
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

