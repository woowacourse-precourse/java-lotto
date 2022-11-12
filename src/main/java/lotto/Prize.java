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

    public Prize(int matching, boolean bouns, int prizeMoney) {
        this.matching = matching;
        this.bouns = bouns;
        this.prizeMoney = prizeMoney;
    }
}