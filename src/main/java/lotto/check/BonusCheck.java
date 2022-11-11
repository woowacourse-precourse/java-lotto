package lotto.check;

import lotto.domain.Const;
import lotto.domain.Lotto;

public class BonusCheck {


    public static Integer check(String bonusNumber, Lotto winningLotto) {
        if (!isNumber(bonusNumber)) {
            throw new IllegalArgumentException(Const.NUM_ERRMSG);
        }
        if (!isRange(bonusNumber)) {
            throw new IllegalArgumentException(Const.RANGE_ERRMSG);
        }
        int bonus = Integer.parseInt(bonusNumber);
        if (winningLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(Const.DUPLICATE_ERRMSG);
        }
        return bonus;
    }

    private static boolean isNumber(String bonusNumber) {
        for (int i = 0; i < bonusNumber.length(); i++) {
            char c = bonusNumber.charAt(i);
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private static boolean isRange(String bonusNumber) {
        int bonus = Integer.parseInt(bonusNumber);
        if (bonus < Const.START_NUMBER || bonus > Const.END_NUMBER) return false;
        return true;
    }
}
