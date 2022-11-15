package lotto;

import java.util.List;

public enum Rank {
    FIFTH("3개 일치 (5,000원) - ", 5000),
    FOURTH("4개 일치 (50,000원) - ", 50000),
    THIRD("5개 일치 (1,500,000원) - ", 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000);

    private final String message;
    private final int cash;

    Rank(String message, int prizeMoney) {
        this.message = message;
        this.cash = prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public int getCash() {
        return cash;
    }

    public static Rank getWinning(int equalNumber, boolean bonus) {
        if (equalNumber == 3) {
            return FIFTH;
        }
        if (equalNumber == 4) {
            return FOURTH;
        }
        if (equalNumber == 5 && !bonus) {
            return THIRD;
        }
        if (equalNumber == 5 && bonus) {
            return SECOND;
        }
        if (equalNumber == 6) {
            return FIRST;
        }
        return null;
    }

    public static List<Rank> getValues() {
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }
}