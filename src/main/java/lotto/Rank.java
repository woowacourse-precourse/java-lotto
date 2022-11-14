package lotto;

import java.util.ArrayList;
import java.util.List;

public enum Rank {
    FIFTH(4, 3, 5000, 0),
    FOURTH(3, 4, 50000, 0),
    THIRD(2, 5, 1500000, 0),
    SECOND(1, 5, 30000000, 1),
    FIRST(0, 6, 2000000000, 0),
    NOTHING(5, 0, 0, 0);
    private int count;
    private int money;
    private int bonus;
    private int idx;

    Rank(int idx, int count, int money, int bonus) {
        this.count = count;
        this.money = money;
        this.bonus = bonus;
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }

    public int getBonus() {
        return bonus;
    }
}
