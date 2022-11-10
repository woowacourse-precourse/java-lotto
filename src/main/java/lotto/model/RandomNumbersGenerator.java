package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

class RandomNumbersGenerator {

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
}
