package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    public long inputPayment() {
        printPaymentMessage();
        String payment = Console.readLine();
        validateNumeric(payment);
        return Long.parseLong(payment);
    }

    public List<Integer> inputWinningNumbers() {
        printWinningNumbersMessage();
        String winningNumbers = Console.readLine();
        validateSeparator(winningNumbers);
        return changeStringToList(winningNumbers);
    }

    public int inputBonusNumber() {
        printBonusNumberMessage();
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public void validateBonusNumber(String input) {
        validateNumeric(input);
        validateNumberRange(Integer.parseInt(input));
    }

    public void validateNumeric(String input) {
        String NUMERIC_ERROR_MESSAGE = "[ERROR] 입력값은 숫자만 가능합니다.";

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NUMERIC_ERROR_MESSAGE);
        }
    }

    public void validateSeparator(String input) {
        String REGEX = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";
        String SEPARATOR_ERROR_MESSAGE = "[ERROR] 6개의 숫자를 쉼표(,)로 구분하여 입력하세요.";

        if (!Pattern.matches(REGEX, input)) {
            throw new IllegalArgumentException(SEPARATOR_ERROR_MESSAGE);
        }
    }

    public void validateNumberRange(int number) {
        final int MIN = 1;
        final int MAX = 45;
        String RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1이상 45이하의 숫자만 가능합니다.";

        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    public List<Integer> changeStringToList(String input) {
        List<Integer> result = new ArrayList<>();
        final String SEPARATOR = ",";

        String[] splitInput = input.split(SEPARATOR);

        for (int i = 0; i < splitInput.length; i++) {
            result.add(Integer.valueOf(splitInput[i]));
        }
        return result;
    }

    private void printPaymentMessage() {
        String PAYMENT_MESSAGE = "구입금액을 입력해 주세요.";
        System.out.println(PAYMENT_MESSAGE);
    }

    private void printWinningNumbersMessage() {
        String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    private void printBonusNumberMessage() {
        String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}