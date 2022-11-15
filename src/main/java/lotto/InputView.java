package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_NOT_DIGIT_MESSAGE = "[ERROR] 입력 값은 숫자가 아닙니다.";
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String COMMA = ",";
    private static final String WHITESPACE = "\\s";
    private static final String EMPTY = "";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();
        validateIsDigit(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println();
        System.out.println(INPUT_WINNING_LOTTO_MESSAGE);
        String input = Console.readLine();
        return Arrays.stream(split(removeBlank(input)))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateIsDigit(input);
        return Integer.parseInt(input);
    }

    private static void validateIsDigit(String input) {
        char[] inputs = input.toCharArray();
        for (char character : inputs) {
            if (!Character.isDigit(character)) {
                System.out.println(INPUT_NOT_DIGIT_MESSAGE);
                throw new NoSuchElementException();
            }
        }
    }

    private static String[] split(String input) {
        return input.split(COMMA);
    }

    private static String removeBlank(String input) {
        return input.replaceAll(WHITESPACE, EMPTY);
    }
}
