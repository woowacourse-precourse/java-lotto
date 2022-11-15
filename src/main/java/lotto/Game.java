package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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
        setLotto();
        if (lotto == null) {
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
}
