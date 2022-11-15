package lotto;

import java.util.List;

public class Bonus {
    private final Lotto lotto;
    private final int bonus;

    public Bonus(Lotto lotto, int bonus) {
        compareWithWinning(lotto, bonus);
        checkBonusInRange(bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static void checkBonusInRange(int bonus) {
        if (!bonusInRange(bonus)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static boolean bonusInRange(int bonus) {
        return bonus >= 1 && bonus <= 45;
    }

    private static void compareWithWinning(Lotto lotto, int bonus) {
        if (lotto.checkBonusInWinning(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 겹치지 않아야 합니다.");
        }
    }
}
