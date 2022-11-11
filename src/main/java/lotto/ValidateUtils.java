package lotto;

import java.util.List;

public class ValidateUtils {
    private static final String ERROR_MEESAGE_HEADER = "[ERROR] ";

    private static final String VALIDATE_MONEY_UNIT = "금액은 1,000원 단위로만 입력 가능합니다. ";
    private static final String VALIDATE_DELIMITER = "당첨 번호는 구분자(',')를 이용하여 입력합니다.";
    private static final String VALIDATE_RANGE_ANSWER_NUMBER = "당첨 번호는 1 ~ 45 범위의 값만 입력합니다.";
    private static final String VALIDATE_SIZE_INPUT = "당첨 번호는 %s개만 입력합니다.";
    private static final String VALIDATE_DUPLICATE_NUMBER = "중복된 당첨 번호는 입력할 수 없습니다.";

    private static final int MONEY_UNIT = 1000;

    public static void checkMoneyUnit(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_MONEY_UNIT));
        }
    }

    public static void checkDelimiter(int splitSize) {
        if (splitSize == 1) {
            throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_DELIMITER));
        }
    }

    public static void checkArraySize(int answersSize, int maxLength) {
        if (answersSize != maxLength) {
            throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_SIZE_INPUT, maxLength));
        }
    }

    public static void checkRangeNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_RANGE_ANSWER_NUMBER));
        }
    }

    public static void checkDuplicateNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_DUPLICATE_NUMBER));
        }
    }
}
