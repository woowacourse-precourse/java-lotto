package lotto.check;

import lotto.domain.Lotto;

public class BonusCheck {
    private final String numErrMsg = "숫자를 입력해 주세요.";
    private final String rangeErrMsg = "숫자는 1~45사이의 숫자를 입력해 주세요.";
    private final String duplicateErrMsg = "숫자가 중복 되었습니다.";
    private final int startNumber = 1;
    private final int endNumber = 45;

    public Integer check(String bonusNumber, Lotto winningLotto) {
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

    private boolean isNumber(String bonusNumber) {
        for (int i = 0; i < bonusNumber.length(); i++) {
            char c = bonusNumber.charAt(i);
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private boolean isRange(String bonusNumber) {
        int bonus = Integer.parseInt(bonusNumber);
        if (bonus < startNumber || bonus > endNumber) return false;
        return true;
    }
}
