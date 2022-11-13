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
        if (isFirst(lotto))
            return 1;
        if (isSecond(lotto))
            return 2;
        if (isThird(lotto))
            return 3;
        if (isFourth(lotto))
            return 4;
        if (isFifth(lotto))
            return 5;
        return -1;
    }

    public boolean isFirst(Lotto lotto) {
        return false;
    }

    public boolean isSecond(Lotto lotto) {
        return false;
    }

    public boolean isThird(Lotto lotto) {
        return false;
    }

    public boolean isFourth(Lotto lotto) {
        return false;
    }

    public boolean isFifth(Lotto lotto) {
        return false;
    }

}
