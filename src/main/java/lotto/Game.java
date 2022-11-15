package lotto;

import java.util.List;

public class Game {

    private static final String DELIMITER = ",";
    private static final long MINIMUM_UNIT = 1000L;
    private static final long ZERO = 0L;
    private static final long INVALID = -1L;

    Calculator calculator;
    Lotto lotto;
    int bonusNum;

    public void init() {
        if (setCalculator()) {
            return;
        }
        if (setLotto()) {
            return;
        }
        if (setBonus()) {
            return;
        }

    }

    private boolean setCalculator() {
        long money = Input.inputMoney();
        if (money == INVALID) {
            return true;
        }
        calculator = new Calculator(money);
        return false;
    }

    private boolean setLotto() {
        List numbers = Input.inputLotto();
        if (numbers == null) {
            return true;
        }
        lotto = new Lotto(numbers);
        return false;
    }

    private boolean setBonus() {
        int bonus = Input.inputBonus();
        try {
            lotto.isBonusDuplicate(bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        bonusNum = bonus;
        return false;
    }
}
