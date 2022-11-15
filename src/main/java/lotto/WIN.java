package lotto;

import java.util.List;
import java.util.Map;

public enum WIN {

    WIN_5TH(3, false, 5_000),
    WIN_4TH(4, false, 50_000),
    WIN_3RD(5, false, 1_500_000),
    WIN_2ND(5, true, 30_000_000),
    WIN_1ST(6, false, 2_000_000_000),
    WIN_NO(0, false, 0);

    private final int sameNumbers;
    private final boolean sameBonus;
    private final int money;

    WIN(int sameNumbers, boolean sameBonus, int money) {
        this.sameNumbers = sameNumbers;
        this.sameBonus = sameBonus;
        this.money= money;
    }

    public int getMoney() {
        return money;
    }

    public int getSameNumbers() {
        return sameNumbers;
    }

    public static WIN getWIN(int sameNumbers, boolean sameBonus) {
        if (sameNumbers == 5) {
            if (sameBonus)
                return WIN_2ND;
            return WIN_3RD;
        }
        if (sameNumbers == 6) {
            return WIN_1ST;
        }
        if (sameNumbers == 4 || sameNumbers == 3) {
            return WIN.valueOf("WIN_" + (8 - sameNumbers) + "TH");
        }
        return WIN_NO;
    }

    public static List<WIN> getAllWIN() {
        return List.of(WIN_5TH, WIN_4TH, WIN_3RD, WIN_2ND, WIN_1ST, WIN_NO);
    }
}