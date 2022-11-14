package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ValidationErrorMessage;
import lotto.view.constant.InputGuidePhrase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    static final String EMPTY_VALUE_ERROR_MESSAGE = ValidationErrorMessage.EMPTY_VALUE.getErrorMessage();
    static final String NOT_NUMBER_ERROR_MESSAGE = ValidationErrorMessage.NOT_NUMBER.getErrorMessage();
    static final String WINNING_NUMBER_REQUEST = InputGuidePhrase.WINNING_NUMBER_REQUEST.getText();
    static final String EMPTY_VALUE_IN_WINNING_NUMBER = ValidationErrorMessage.EMPTY_VALUE_IN_WINNING_NUMBER.getErrorMessage();
    static final String WINNING_NUMBER_DELIMITER = ",";

    public static int takeMoneyInput() {
        printPurchaseMoneyRequest();
        String input = Console.readLine().trim();
        validate(input);
        return Integer.parseInt(input);
    }

    private static void printPurchaseMoneyRequest() {
        System.out.println(InputGuidePhrase.PURCHASE_MONEY_REQUEST.getText());
    }

    private static void validate (String input) {
        if (Validator.isEmpty(input)) {
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR_MESSAGE);
        }

        if (!Validator.isNumber(input)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static List<Integer> takeWinningNumberInput() {
        System.out.println(WINNING_NUMBER_REQUEST);
        String input = Console.readLine().trim();
        validateWinningNumberInput(input);
        return divideByDelimiter(input).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateWinningNumberInput (String input) {
        if (Validator.isEmpty(input)) {
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR_MESSAGE);
        }

        List<String> numbers = divideByDelimiter(input);
        if (Validator.hasEmptyValue(numbers)) {
            throw new IllegalArgumentException(EMPTY_VALUE_IN_WINNING_NUMBER);
        }

        if (Validator.hasNonNumericValue(numbers)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static List<String> divideByDelimiter (String input) {
        return Arrays.stream(input.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
