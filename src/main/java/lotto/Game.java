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
        setCalculator();
        setLotto();
        setBonus();
        for (List<Integer> randomNumbers : calculator.lotteries) {
            lotto.compareLotto(randomNumbers, bonusNum);
        }
        calculator.printResult();
    }

    private void setCalculator() {
        long money = Input.inputMoney();
        calculator = new Calculator(money);
        Message.BLANK_LINE.print();
    }

    private boolean setLotto() {
        List numbers = Input.inputLotto();
        lotto = new Lotto(numbers);
        Message.BLANK_LINE.print();
        return false;
    }

    private boolean setBonus() {
        int bonus = Input.inputBonus();
        lotto.isBonusDuplicate(bonus);
        bonusNum = bonus;
        Message.BLANK_LINE.print();
        return false;
    }
}
