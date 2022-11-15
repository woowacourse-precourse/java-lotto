package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Constant;

public class InputView {
    private static final String REMOVE_WHITESPACES_REGEX = "\\s+";
    private static final String ONLY_DIGIT_REGEX = "[0-9]";
    private static final String MESSAGE_FOR_INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_FOR_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_FOR_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_INVALID_NUMBER_FORMAT = "[ERROR] 숫자만 입력해 주세요.";
    private static final String ERROR_INVALID_DELIMITER_FORMAT = "[ERROR] 구분자로 쉼표(,)를 입력해 주세요.";

    public static int getInputMoney() {
        try {
            System.out.println(MESSAGE_FOR_INPUT_PRICE);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_FORMAT);
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(Constant.NEW_LINE);
        System.out.println(MESSAGE_FOR_WINNING_NUMBERS);
        return scanWinningNumbers();
    }

    private static List<Integer> scanWinningNumbers() {
        String inputNumbers = removeWhiteSpaces(Console.readLine());

        if (!isContainsComma(inputNumbers)) {
            throw new IllegalArgumentException(ERROR_INVALID_DELIMITER_FORMAT);
        }
        if (!(isContainsComma(inputNumbers) || isOnlyDigit(inputNumbers))) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_FORMAT);
        }
        return Arrays.stream(inputNumbers.split(Constant.DELIMITER_FORMAT))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean isOnlyDigit(String inputNumbers) {
        return inputNumbers.matches(ONLY_DIGIT_REGEX);
    }

    private static boolean isContainsComma(String inputNumbers) {
        return inputNumbers.contains(Constant.DELIMITER_FORMAT);
    }

    public static String removeWhiteSpaces(String inputString) {
        return inputString.replaceAll(REMOVE_WHITESPACES_REGEX, "");
    }
}
