package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.Validator;

public final class Input {
    private static final Validator validator = new Validator();

    public static int inputPurchaseAmount() {
        String input = validator.validateDigit(readLine());
        return convertToInt(input);
    }

    public static String inputWinningNumbers() {
        return validator.validateDigitAndComma(readLine());
    }

    public static int inputBonusNumber() {
        String input = validator.validateDigit(readLine());
        return validator.validateNumberRange(convertToInt(input));
    }

    private static int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    private Input() {
    }
}
