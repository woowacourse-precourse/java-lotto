package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String VALUE_IS_NON_NUMERIC_MESSAGE = "입력값은 정수여야 합니다.";

    public static int inputPurchaseAmount() {
        return inputInteger();
    }

    private static int inputInteger() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(VALUE_IS_NON_NUMERIC_MESSAGE);
        }
    }
}
