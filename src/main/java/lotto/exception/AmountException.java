package lotto.exception;

public class AmountException {
    private static final String ERROR_MESSAGE = "[ERROR] 구입 금액은 ";
    private static final String NUMERIC_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String UNIT_EXCEPTION_MESSAGE = "원 단위의 금액만 가능합니다.";

    public static void validateAmount(String input) {
        StringBuilder message = new StringBuilder(ERROR_MESSAGE);

        if(!isNumeric(input)) {
            message.append(NUMERIC_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(message.toString());
        } else if(!isAccurateUnit(input)) {
            message.append(1000).append(UNIT_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(message.toString());
        }
    }

    private static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    private static boolean isAccurateUnit(String input) {
        if(Integer.parseInt(input) % 1000 != 0) return false;
        return true;
    }
}
