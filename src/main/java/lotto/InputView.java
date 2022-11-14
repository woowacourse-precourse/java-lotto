package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";
    private static final long MINIMUM_UNIT = 1000L;
    private static final long ZERO = 0L;
    private InputView(){}

    static public Calculator inputMoney() {
        Message.INPUT_MONEY.print();
        String input = Console.readLine();
        try {
            validateMoney(input);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        long money = Long.parseLong(input);
        return new Calculator(money);
    }

    static private void validateMoney(String input) {
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

    static public Lotto inputWinningNumber() {
        Message.INPUT_LOTTERY_NUMBER.print();
        String winningNumber = Console.readLine();
        List numbers = validateLotto(winningNumber);
        return new Lotto(numbers);
    }

    static private List validateLotto(String winningNumber) {
        String[] splitInput = winningNumber.split(DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        validateLottoType(splitInput, numbers);

        return numbers;
    }

    static private void validateLottoType(String[] splitInput, List<Integer> numbers) {
        try {
            for (int i = 0; i < splitInput.length; i++) {
                numbers.add(Integer.parseInt(splitInput[i].trim()));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.printError());
        }
    }
}
