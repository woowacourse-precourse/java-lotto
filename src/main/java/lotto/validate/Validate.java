package lotto.validate;

import org.assertj.core.util.Strings;

public class Validate {
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static void validateIsNumber(String purchasingMoney) throws IllegalArgumentException {
        try {
            Integer.parseInt(purchasingMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자를 입력하셔야 합니다.");
        }
    }

    public static void validateIsNullOrEmpty(String input) throws IllegalArgumentException {
        if (Strings.isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 번호를 입력하셔야 합니다.");
        }
    }

    public static void validateEndsWithThreeZeros(String purchasingMoney) throws IllegalArgumentException {
        if (!purchasingMoney.substring(purchasingMoney.length() - 3)
                .equals("000")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 천원 단위로 입력하셔야 합니다.");
        }
    }
}
