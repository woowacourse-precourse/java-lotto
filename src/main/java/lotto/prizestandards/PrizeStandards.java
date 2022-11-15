package lotto.prizestandards;
import java.util.Arrays;

public enum PrizeStandards {

    THREE_MATCH(6, 5000),
    FOUR_MATCH(8, 50000),
    FIVE_MATCH(10, 1500000),
    FIVE_BONUS(11, 3000000),
    SIX_MATCH(12, 2000000000),
    UNDER_PRIZE(0, 0);

    private final int score;
    private final int money;

    PrizeStandards(int i, int j) {
        this.score = i;
        this.money = j;
    }

    public int getMoney() {
        return money;
    }

    public static Enum<PrizeStandards> getProperStandard(int givenScore) {
        return Arrays.stream(PrizeStandards.values())
                .filter(prizeStandards -> prizeStandards.score == givenScore)
                .findFirst()
                .orElse(UNDER_PRIZE);
    }
}
