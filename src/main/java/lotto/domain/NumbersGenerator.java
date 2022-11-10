package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import lotto.Constants;

public class NumbersGenerator {

    public List<Integer> generatorNumbers() {
        return sortNumbers(Randoms.pickUniqueNumbersInRange(Constants.MIN_NUMBER_RANGE.getValue(),
                Constants.MAX_NUMBER_RANGE.getValue(), Constants.NUMBERS_LENGTH.getValue()));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
