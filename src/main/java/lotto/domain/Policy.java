package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class Policy {

    public enum Prize {
    FIFTH_PRIZE(5000),
    FOURTH_PRIZE(50000),
    THIRD_PRIZE(1500000),
    SECOND_PRIZE(30000000),
    FIRST_PRIZE(2000000000);

    private final int prize;

    Prize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}

    public enum Match {
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6);

    private final int match;

        Match(int match) {
            this.match = match;
        }
    public int getMatch() {
            return match;
        }
}

    public static List<Integer> count = new ArrayList<>();

    public static int bonusCount = 0;

    public static void increaseBonusCount() {
        bonusCount ++;
    }

}
