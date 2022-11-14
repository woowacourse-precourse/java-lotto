package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";
    private static final long MINIMUM_UNIT = 1000L;
    private static final long ZERO = 0L;

    Calculator calculator;
    Lotto lotto;

    int bonusNum;

    public boolean inputMoney() {
        long money = ZERO;
        Message.INPUT_MONEY.print();
        String input = Console.readLine();
        try {
            validateMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        money = Long.parseLong(input);
        this.calculator = new Calculator(money);
        return false;
    }

    private void validateMoney(String input) {
        long money;
        try {
            money = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.printError());
        }
        if (money % MINIMUM_UNIT != ZERO || money == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_1000.printError());
        }
    }

    public boolean inputWinningNumber() {
        Message.INPUT_LOTTERY_NUMBER.print();
        List numbers;
        String winningNumber = Console.readLine();
        try {
            numbers = validateLotto(winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        lotto = new Lotto(numbers);
        return false;
    }

    private List validateLotto(String winningNumber) {
        String[] splitInput = winningNumber.split(DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        validateLottoType(splitInput, numbers);

        return numbers;
    }

    private void validateLottoType(String[] splitInput, List<Integer> numbers) {
        try {
            for (int i = 0; i < splitInput.length; i++) {
                numbers.add(Integer.parseInt(splitInput[i].trim()));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.printError());
        }
    }

    public boolean inputBonus() {
        Message.INPUT_BONUS_NUMBER.print();
        String bonus = Console.readLine();
        try {
            this.bonusNum = lotto.validateBonus(bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
}
