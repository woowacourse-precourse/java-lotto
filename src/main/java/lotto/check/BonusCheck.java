package lotto.check;

import lotto.domain.Const;
import lotto.domain.Lotto;

public class BonusCheck {
    private static final String numErrMsg = "숫자를 입력해 주세요.";
    private static final String rangeErrMsg = "숫자는 1~45사이의 숫자를 입력해 주세요.";
    private static final String duplicateErrMsg = "숫자가 중복 되었습니다.";

    public static Integer check(String bonusNumber, Lotto winningLotto) {
        if (!isNumber(bonusNumber)) {
            throw new IllegalArgumentException(numErrMsg);
        }
        if (!isRange(bonusNumber)) {
            throw new IllegalArgumentException(rangeErrMsg);
        }
        int bonus = Integer.parseInt(bonusNumber);
        if (winningLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(duplicateErrMsg);
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
