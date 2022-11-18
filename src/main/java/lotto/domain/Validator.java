package lotto.domain;

import lotto.view.IOProcessor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private enum Messages {
        BOUNS_NUMBER_UNIQUENESS_FAILED("입력한 보너스 번호가 이미 당첨번호에 있습니다."),
        NUMBER_CHECK_FAILED("입력 내용이 숫자로 구성되어 있지 않습니다."),
        AMOUNT_UNIT_FAILED_FRONT("구매금액의 단위가 "),
        AMOUNT_UNIT_FAILED_REAR("원이 아닙니다."),
        FORMAT_VALIDATION_FAILED("당첨번호 입력형식이 올바르지 않습니다."),
        NUMBER_RANGE_VALIDATION_FAILED("입력한 값의 범위가 올바르지 않습니다."),
        WINNING_NUMBER_EACH_DIGIT_UNIQUENESS_FAILED("당첨번호는 서로 다른 6개의 수로 구성되어야 합니다.");

        private final String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static void amountIsValid(String userInput, int unit) throws IllegalArgumentException {
        isNumber(userInput);
        int amount = Integer.parseInt(userInput);
        amountUnitIsValid(amount, unit);
    }

    public static List<Integer> winningNumberIsValid(String userInput) throws IllegalArgumentException {
        String[] numbers = winningNumberFormatIsValid(userInput);
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        for (int number : winningNumbers) {
            isValidRange(number, 1, 45);
        }
        return eachNumberIsUnique(winningNumbers);
    }

    public static int bonusNumberIsValid(String userInput, List<Integer> winningNumber) throws IllegalArgumentException {
        isNumber(userInput);
        int bonusNumber = Integer.parseInt(userInput);
        isValidRange(bonusNumber, 1, 45);
        if (winningNumber.contains(bonusNumber)) {
            IOProcessor.printErrorMessage(Messages.BOUNS_NUMBER_UNIQUENESS_FAILED.getMessage());
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    private static void isNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                IOProcessor.printErrorMessage(Messages.NUMBER_CHECK_FAILED.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    private static void amountUnitIsValid(int amount, int unit) {
        if (amount % unit != 0) {
            IOProcessor.printErrorMessage(Messages.AMOUNT_UNIT_FAILED_FRONT.getMessage()
                    + unit
                    + Messages.AMOUNT_UNIT_FAILED_REAR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static String[] winningNumberFormatIsValid(String userInput) {
        String[] numbers = userInput.split(",");

        if (numbers.length != 6) {
            IOProcessor.printErrorMessage(Messages.FORMAT_VALIDATION_FAILED.getMessage());
            throw new IllegalArgumentException();
        }

        for (String number : numbers) {
            isNumber(number);
        }
        return numbers;
    }

    private static void isValidRange(int number, int start, int end) {
        if (number < start || number > end) {
            IOProcessor.printErrorMessage(Messages.NUMBER_RANGE_VALIDATION_FAILED.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> eachNumberIsUnique(List<Integer> numbers) {
        Set<Integer> winningNumberPool = new HashSet<>();
        winningNumberPool.addAll(numbers);

        if (numbers.size() != winningNumberPool.size()) {
            IOProcessor.printErrorMessage(Messages.WINNING_NUMBER_EACH_DIGIT_UNIQUENESS_FAILED.getMessage());
            throw new IllegalArgumentException();
        }
        return numbers;
    }
}
