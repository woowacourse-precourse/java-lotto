package lotto.domain;

import java.util.Map;

enum Prize {
    ThreeMatch(5000),
    FourMatch(50000),
    FiveMatch(1500000),
    FiveAndBonusMatch(30000000),
    SixMatch(2000000000),
    NoMatch(0);

    final int cash;

    Prize(int cash) {
        this.cash = cash;
    }
}

public class Winnings {
    static final double[] correctNums = {3, 4, 5, 5.5, 6};

    public static int getWinnings(double num) {
        if (num == 6) {
            return Prize.SixMatch.cash;
        } else if (num == 5) {
            return Prize.FiveMatch.cash;
        } else if (num == 5.5) {
            return Prize.FiveAndBonusMatch.cash;
        } else if (num == 4) {
            return Prize.FourMatch.cash;
        } else if (num == 3) {
            return Prize.ThreeMatch.cash;
        }
        return Prize.NoMatch.cash;
    }

    public static double[] getCorrectNums() {
        return correctNums;
    }

}
