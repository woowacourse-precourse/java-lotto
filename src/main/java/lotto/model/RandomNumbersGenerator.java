package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

class RandomNumbersGenerator {

    public static final String REPEAT_NUMBER_ERROR = "중복된 숫자가 있습니다.";
    public static final String NUMBERS_SIZE_ERROR = "[ERROR] 숫자가 6개이여야 합니다.";
    public static final int REQUIRED_SIZE = 6;


    public static List<Integer> creatSixDifferentNumbers() {
        List<Integer> result = pickUniqueNumbersInRange(1, 46, 6);
        isValidSize(result);
        return result;
    }

    public static void isValidSize(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR);
        }
    }

    public static void isValidRepeat(List<Integer> numbers) {
        long numbersSize = numbers.stream().distinct().count();
        if (numbersSize != REQUIRED_SIZE) {
            throw new IllegalArgumentException(REPEAT_NUMBER_ERROR);
        }
    }
}
