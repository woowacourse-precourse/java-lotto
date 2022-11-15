package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import lotto.view.constant.InputGuidePhrase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String EMPTY_VALUE_ERROR_MESSAGE = ErrorMessage.EMPTY_VALUE.getErrorMessage();
    private static final String NOT_NUMBER_ERROR_MESSAGE = ErrorMessage.NOT_NUMBER.getErrorMessage();
    private static final String MISSING_VALUE_ERROR_MESSAGE = ErrorMessage.MISSING_VALUE.getErrorMessage();
    private static final String WINNING_NUMBER_REQUEST = InputGuidePhrase.WINNING_NUMBER_REQUEST.getPhrase();
    private static final String BONUS_NUMBER_REQUEST = InputGuidePhrase.BONUS_NUMBER_REQUEST.getPhrase();
    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static int takeMoneyInput() throws IllegalArgumentException {
        printPurchaseMoneyRequest();
        String input = Console.readLine().trim();
        validate(input);
        return Integer.parseInt(input);
    }

    private static void printPurchaseMoneyRequest() {
        System.out.println(InputGuidePhrase.PURCHASE_MONEY_REQUEST.getPhrase());
    }

    private static void validate (String input) throws IllegalArgumentException {
        if (ViewValidator.isEmpty(input)) {
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR_MESSAGE);
        }

        if (!ViewValidator.isNumber(input)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static List<Integer> takeWinningNumberInput() throws IllegalArgumentException {
        System.out.println(WINNING_NUMBER_REQUEST);
        String input = Console.readLine().trim();
        validateWinningNumberInput(input);
        return divideByDelimiter(input).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateWinningNumberInput (String input) throws IllegalArgumentException {
        if (ViewValidator.isEmpty(input)) {
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR_MESSAGE);
        }

        List<String> numbers = divideByDelimiter(input);
        if (ViewValidator.hasEmptyValue(numbers)) {
            throw new IllegalArgumentException(MISSING_VALUE_ERROR_MESSAGE);
        }

        if (ViewValidator.hasNonNumericValue(numbers)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static List<String> divideByDelimiter (String input) {
        return Arrays.stream(input.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int takeBonusNumberInput() {
        System.out.println(BONUS_NUMBER_REQUEST);
        String input = Console.readLine().trim();
        validate(input);
        return Integer.parseInt(input);
    }
}
