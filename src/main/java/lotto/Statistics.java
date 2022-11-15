package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Statistics {
    private static final int first = 2_000_000_000;
    private static final int second = 30_000_000;
    private static final int third = 1_500_000;
    private static final int fourth = 50_000;
    private static final int fifth = 5_000;

    private final Lotto winning;
    private final int bonus;
    private static final List<Integer> reward = new ArrayList<>(Arrays.asList(first, second, third, fourth, fifth));


    public Statistics(Lotto winning, int bonus) {
        this.winning = winning;
        this.bonus = bonus;
    }

    public int getPrize(Lotto lotto) {
        int count = getCount(lotto);
        if (count == 6)
            return 1;
        if (count == 5) {
            if (isContainsBonus(lotto))
                return 2;
            return 3;
        }
        if (count == 4)
            return 4;
        if (count == 3)
            return 5;
        return -1;
    }

    private int getCount(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (winning.getNumbers().contains(lotto.getNumbers().get(i)))
                count++;
        }
        return count;
    }

    private boolean isContainsBonus(Lotto lotto) {
        if (lotto.getNumbers().contains(bonus))
            return true;
        return false;
    }


    public static double getYield(int cost, List<Integer> winningCount) {
        int totalReward = 0;
        for (int i = 0; i < winningCount.size(); i++) {
            totalReward += winningCount.get(i) * reward.get(i);
        }
        return (double) totalReward / (double) cost * 100;
    }
}
