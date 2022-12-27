package lotto.lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.inputNumber.InputNumber;

import java.util.List;
import java.util.regex.Pattern;

public class WinningNumberLotto extends Lotto {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private int bonusNumber;

    public WinningNumberLotto() {
        super(InputNumber.createNumber());
        printBonusMessage();
        int number = inputBonusNumber();
        setBonusNumber(number);
    }

    public WinningNumberLotto(List<Integer> numbers, int number) {
        super(numbers);
        printBonusMessage();
        setBonusNumber(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private int inputBonusNumber() {
        String input = Console.readLine();
        validateBonusNumber(input);
        return Integer.parseInt(input);
    }

    private void validateBonusNumber(String input) {
        if (!checkInteger(input)) {
            String errorMessage = "[ERROR] 보너스 번호는 자연수 값을 입력해주세요.";
            throw new IllegalArgumentException(errorMessage);
        }
        if (!checkRange(input)) {
            String errorMessage = "[ERROR] 보너스 번호는" + START_NUMBER + "부터 " + END_NUMBER + "의 값을 입력해주세요.";
            throw new IllegalArgumentException(errorMessage);
        }
        if (!checkDuplicated(input)) {
            String errorMessage = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 값으로 입력해주세요.";
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void printBonusMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    private boolean checkInteger(String input) {
        return Pattern.matches("^[0-9]*$", input);
    }

    private boolean checkRange(String input) {
        int number = Integer.parseInt(input);
        return START_NUMBER <= number && number <= END_NUMBER;
    }

    private boolean checkDuplicated(String input) {
        int number = Integer.parseInt(input);
        return !getLotto().contains(number);
    }
}
