package lotto.prizestandards;

import java.util.Arrays;

public enum PrizeStandards {

    THREEMATCH(6, 5000),
    FOURMATCH(8, 50000),
    FIVEMATCH(10, 1500000),
    FIVEBONUS(11, 3000000),
    SIXMATCH(12, 2000000000),
    UNDERPRIZE(0,0);

    private final int score;
    private final int money;

    PrizeStandards(int i, int j) {
        this.score = i;
        this.money = j;
    }

    public int getScore() {
        return score;
    }

    public int getMoney() {
        return money;
    }

    public static Enum<PrizeStandards> getProperStandard(int givenScore) {
        return Arrays.stream(PrizeStandards.values())
                .filter(prizeStandards -> prizeStandards.score == givenScore)
                .findFirst()
                .orElse(UNDERPRIZE);
    }
}
