package lotto.domain;

public enum WinningType {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false);

    WinningType(int equalCount, int winnings, boolean withBonus) {}
}
