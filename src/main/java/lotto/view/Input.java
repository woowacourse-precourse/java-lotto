package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.ConstantUtil.ERROR;
import static lotto.utils.ConstantUtil.MAX_LOTTO_NUMBER;
import static lotto.utils.ConstantUtil.MIN_LOTTO_NUMBER;

public final class Input {
    private static final String DIGIT_ERROR_MESSAGE = ERROR + "숫자를 입력해주세요.";
    private static final String DIGIT_COMMA_ERROR_MESSAGE = ERROR + "당첨 번호를 ,로 구분지어 입력해주세요.";
    private static final String RANGE_ERROR_MESSAGE = ERROR + "번호는 1 ~ 45까지 가능합니다.";

    public static int inputPurchaseAmount() {
        return validateDigit(readLine());
    }

    public static String inputWinningNumbers() {
        String input = validateDigitAndComma(readLine());

        for (String number : input.split(",")) {
            validateNumberRange(convertToInt(number));
        }

        return input;
    }

    public static int inputBonusNumber() {
        int input = validateDigit(readLine());
        return validateNumberRange(input);
    }

    private static int validateDigit(String input) {
        try {
            return convertToInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }
    }

    private static String validateDigitAndComma(String input) {
        String replacedResult = input.replaceAll("[0-9,]", "");

        if (replacedResult.length() != 0) {
            throw new IllegalArgumentException(DIGIT_COMMA_ERROR_MESSAGE);
        }

        return input;
    }

    private static int validateNumberRange(int number) {
        if (isNotValidRange(number)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }

        return number;
    }

    private static boolean isNotValidRange(int number) {
        return (!(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER));
    }

    private static int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    private Input() {
    }
}
