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
        setCalculator();
        if (calculator == null) {
            return;
        }
        setLotto();
        if (lotto == null) {
            return;
        }

    }

    private void setCalculator() {
        long money = Input.inputMoney();
        if (money == INVALID) {
            return;
        }
        calculator = new Calculator(money);
    }

    private void setLotto() {
        List numbers = Input.inputLotto();
        lotto = new Lotto(numbers);
    }
}
