package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.model.NumbersValidator.NUMBER_MAX_VALUE;
import static lotto.model.NumbersValidator.NUMBER_MIN_VALUE;
import static lotto.model.NumbersValidator.NUMBER_REQUIRED_SIZE;
import static lotto.model.NumbersValidator.isValid;

import java.util.List;

class RandomNumbersGenerator {

    public static List<Integer> creatSixDifferentNumbers() {
        List<Integer> result = pickUniqueNumbersInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE,
                NUMBER_REQUIRED_SIZE);
        isValid(result);
        return result;
    }
}
