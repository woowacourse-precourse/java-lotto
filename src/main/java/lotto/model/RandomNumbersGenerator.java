package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

class RandomNumbersGenerator {
    public static final int NUMBER_REQUIRED_SIZE = 6;
    public static final int NUMBER_MIN_VALUE = 1;
    public static final int NUMBER_MAX_VALUE = 45;
    public static final int NUMBER_MAX_VALUE_ADD_ONE = NUMBER_MAX_VALUE + 1;
    public static final String NUMBER_REPEAT_ERROR = "[ERROR] 중복된 숫자가 있습니다.";
    public static final String NUMBERS_SIZE_ERROR = "[ERROR] 숫자가 " + NUMBER_REQUIRED_SIZE + "개이여야 합니다.";
    public static final String NUMBER_RANGE_ERROR =
            "[ERROR] 모든 수가 범위(" + NUMBER_MIN_VALUE + "~" + NUMBER_MAX_VALUE + ")안에 있어야 합니다.";


    public static List<Integer> creatSixDifferentNumbers() {
        List<Integer> result = pickUniqueNumbersInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE_ADD_ONE,
                NUMBER_REQUIRED_SIZE);
        isValidSize(result);
        return result;
    }

    public static void isValidSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_REQUIRED_SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR);
        }
    }

    public static void isValidRepeat(List<Integer> numbers) {
        long numbersSize = numbers.stream().distinct().count();
        if (numbersSize != NUMBER_REQUIRED_SIZE) {
            throw new IllegalArgumentException(NUMBER_REPEAT_ERROR);
        }
    }

    public static void isValidRange(List<Integer> numbers) {
        boolean anyMatch = numbers.stream()
                .anyMatch(number -> number < NUMBER_MIN_VALUE || number > NUMBER_MAX_VALUE);
        if (anyMatch) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }
    }
}
