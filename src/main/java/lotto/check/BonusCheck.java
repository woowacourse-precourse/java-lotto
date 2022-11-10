package lotto.check;

import lotto.Lotto;

public class BonusCheck {

    private final int startNumber = 1;
    private final int endNumber = 45;

    public Integer check(String bonusNumber, Lotto winningLotto) {
        if (!isNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        if (!isRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        int bonus = Integer.parseInt(bonusNumber);
        if (winningLotto.getNumbers().contains(bonus)){
            throw new IllegalArgumentException();
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
