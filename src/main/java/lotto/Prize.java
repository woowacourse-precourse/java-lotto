package lotto;

import java.util.List;

public enum Prize {
    PRIZE1(6, false, 2000000000),
    PRIZE2(5, true, 30000000),
    PRIZE3(5, false, 1500000),
    PRIZE4(4, false, 50000),
    PRIZE5(3, false, 5000)
    ;
    private int matching;
    private boolean bonus;
    private int prizeMoney;

    Prize(int count, boolean bonus, int prizeMoney) {
        this.matching = count;
        this.bonus = bonus;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}