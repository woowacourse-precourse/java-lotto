package lotto.validator;

import java.util.Arrays;

import static lotto.util.Const.*;

public class ParserValidator {

    public static void check(String[] inputString) throws IllegalArgumentException {
        checkNumberCondition(inputString);
        checkSize(inputString);
        checkUnique(inputString);
    }

    private static void checkSize(String[] splitNumbers) {
        if (isWrongSize(splitNumbers)) {
            throw new IllegalArgumentException("당첨 숫자 개수는 6개여야 합니다.");
        }
    }

    private static void checkNumberCondition(String[] splitNumbers) {
        Arrays.stream(splitNumbers)
                .filter(number -> isNotDigit(number) || isWrongRangeNumber(Integer.valueOf(number)))
                .forEach(number -> {
                    throw new IllegalArgumentException("구분자 ','와 1 ~ 45 숫자 이외는 입력할 수 없습니다.");
                });
    }

    private static void checkUnique(String[] splitNumbers) {
        if (getUniqueNumberCount(splitNumbers) != LOTTO_SIZE) {
            throw new IllegalArgumentException("중복된 당첨 숫자를 입력할 수 없습니다.");
        }
    }

    private static long getUniqueNumberCount(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .distinct()
                .count();
    }

    private static boolean isNotDigit(String number) {
        final String regex = "^[0-9]+$";
        return !number.matches(regex);
    }

    private static boolean isWrongRangeNumber(int number) {
        return (number < START_NUMBER || number > END_NUMBER);
    }

    private static boolean isWrongSize(String[] numbers) {
        return numbers.length != LOTTO_SIZE;
    }
}
