package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public enum Win {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private int correctCount;
    private int winnings;
    private static Map<Win, Integer> wins;

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public static Map<Win, Integer> getWins() {
        return wins;
    }

    Win(final int matchCount, final int winnings) {
        this.correctCount = matchCount;
        this.winnings = winnings;
    }

    public static Win getWin(final int correctCount, final boolean bonus) {
        if (correctCount == FIRST.correctCount) {
            return FIRST;
        }

        if (correctCount == SECOND.correctCount && bonus) {
            return SECOND;
        }

        if (correctCount == THIRD.correctCount && !bonus) {
            return THIRD;
        }

        if (correctCount == FOURTH.correctCount) {
            return FOURTH;
        }

        if (correctCount == FIFTH.correctCount) {
            return FIFTH;
        }

        if (correctCount < FIFTH.correctCount) {
            return NONE;
        }
        return null;
    }

    public static void initWins() {
        wins = new EnumMap<Win, Integer>(Win.class);
        for (Win win : Win.values()) {
            wins.put(win, 0);
        }
    }

    public static void plusWin(Win win) {
        wins.put(win, wins.get(win)+1);
    }
}
