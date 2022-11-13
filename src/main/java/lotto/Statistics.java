package lotto;

import java.util.List;

public class Statistics {
    private final Lotto winning;
    private final int bonus;

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

    public int getCount(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (winning.getNumbers().contains(lotto.getNumbers().get(i)))
                count++;
        }
        return count;
    }

    public boolean isContainsBonus(Lotto lotto) {
        if (lotto.getNumbers().contains(bonus))
            return true;
        return false;
    }
}
