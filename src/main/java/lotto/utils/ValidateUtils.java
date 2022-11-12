package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateUtils {
    private static final String ERROR_MEESAGE_HEADER = "[ERROR] ";

    private static final String VALIDATE_MONEY_TYPE = "금액은 숫자만 입력 가능합니다. ";
    private static final String VALIDATE_MONEY_UNIT = "금액은 1,000원 단위로만 입력 가능합니다. ";
    private static final String VALIDATE_DELIMITER = "당첨 번호는 구분자(',')를 이용하여 입력합니다.";
    private static final String VALIDATE_RANGE_ANSWER_NUMBER = "당첨 번호는 1 ~ 45 범위의 값만 입력합니다.";
    private static final String VALIDATE_SIZE_INPUT = "당첨 번호는 %s개만 입력합니다.";
    private static final String VALIDATE_DUPLICATE_NUMBER = "중복된 당첨 번호는 입력할 수 없습니다.";

    public static void checkTypeNumber(String money) {
        for (int i = 0; i < money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                System.out.println(ERROR_MEESAGE_HEADER + VALIDATE_MONEY_TYPE);
                throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_MONEY_TYPE));
            }
        }
    }

    public static void checkMoneyUnit(int money) {
        if (money % Constant.MONEY_UNIT != 0) {
            System.out.println(ERROR_MEESAGE_HEADER + VALIDATE_MONEY_UNIT);
            throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_MONEY_UNIT));
        }
    }

    public static void checkDelimiter(int splitSize) {
        if (splitSize == 1) {
            System.out.println(ERROR_MEESAGE_HEADER + VALIDATE_DELIMITER);
            throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_DELIMITER));
        }
    }

    public static void checkArraySize(int answersSize, int maxLength) {
        if (answersSize != maxLength) {
            System.out.println(String.format(ERROR_MEESAGE_HEADER + VALIDATE_SIZE_INPUT, maxLength));
            throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_SIZE_INPUT, maxLength));
        }
    }

    public static void checkRangeNumber(int number) {
        if (number < Constant.NUMBER_START || number > Constant.NUMBER_END) {
            System.out.println(ERROR_MEESAGE_HEADER + VALIDATE_RANGE_ANSWER_NUMBER);
            throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_RANGE_ANSWER_NUMBER));
        }
    }

    public static void checkRangeNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Constant.NUMBER_START || number > Constant.NUMBER_END) {
                System.out.println(ERROR_MEESAGE_HEADER + VALIDATE_RANGE_ANSWER_NUMBER);
                throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_RANGE_ANSWER_NUMBER));
            }
        }
    }

    public static void checkDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            System.out.println(ERROR_MEESAGE_HEADER + VALIDATE_DUPLICATE_NUMBER);
            throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_DUPLICATE_NUMBER));
        }
    }

    public static void checkDuplicateNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            System.out.println(ERROR_MEESAGE_HEADER + VALIDATE_DUPLICATE_NUMBER);
            throw new IllegalArgumentException(String.format(ERROR_MEESAGE_HEADER + VALIDATE_DUPLICATE_NUMBER));
        }
    }
}
