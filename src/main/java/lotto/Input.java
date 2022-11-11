package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public final class Input {
    private static final Validator validator = new Validator();

    public static int inputPurchaseAmount() {
        String input = validator.validateDigit(readLine());
        return convertToInt(input);
    }

    public static String inputWinningNumbers() {
        return validator.validateDigitAndComma(readLine());
    }

    private static int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    private Input() {
    }
}
