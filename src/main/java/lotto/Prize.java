package lotto;

import java.util.List;

public enum Prize {
    PRIZE1(6, false, 2000000000),
    PRIZE2(5, true, 30000000),
    PRIZE3(5, false, 1500000),
    PRIZE4(4, false, 50000),
    PRIZE5(3, false, 5000)
    ;
    private int matching = 0;
    private boolean bonus = false;
    private int prizeMoney = 0;

    Prize(int count, boolean bonus, int prizeMoney) {
        this.matching = count;
        this.bonus = bonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(int count, boolean bonus) {
        if (count == 6) {
            return Prize.PRIZE1;
        }
        if (count == 5 && bonus) {
            return Prize.PRIZE2;
        }
        if (count == 5) {
            return Prize.PRIZE3;
        }
        if (count == 4) {
            return Prize.PRIZE4;
        }
        if (count == 3) {
            return Prize.PRIZE5;
        }
        return null;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}