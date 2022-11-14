package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_NOT_DIGIT_MESSAGE = "[ERROR] 입력 값은 숫자가 아닙니다.";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();
        validateIsDigit(input);
        return Integer.parseInt(Console.readLine());
    }

    private static void validateIsDigit(String input) {
        char[] inputs = input.toCharArray();
        for (char character : inputs) {
            if (!Character.isDigit(character)) {
                throw new IllegalArgumentException(INPUT_NOT_DIGIT_MESSAGE);
            }
        }
    }
}
