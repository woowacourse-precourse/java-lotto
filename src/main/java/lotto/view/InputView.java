package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_ERROR_MESSAGE = "구입 금액은 문자일 수 없습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_ERROR_MESSAGE = "올바른 당첨 번호 입력이 아닙니다.";
    private static final String DELIMITER = ",";

    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        int money = toInteger(Console.readLine());
        System.out.println();
        return money;
    }

    private static int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_ERROR_MESSAGE);
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return toIntegerList(Console.readLine());
    }

    private static List<Integer> toIntegerList(String input) {
        try {
            validateWinningNumbersInput(input);
            return Arrays.stream(input.split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBERS_ERROR_MESSAGE);
        }
    }

    private static void validateWinningNumbersInput(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_ERROR_MESSAGE);
        }
    }
}
