package lotto.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidLength(numbers);
        isAllUnique(numbers);
        isAllInRange(numbers);
    }

    private void isValidLength(List<Integer> numbers) {
        if (numbers.size() != Constants.NUMBER_LENGTH) {
            throw new IllegalArgumentException(LottoError.LENGTH.message());
        }
    }

    private void isAllUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Constants.NUMBER_LENGTH) {
            throw new IllegalArgumentException(LottoError.UNIQUE.message());
        }
    }

    private void isAllInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Constants.NUMBER_RANGE_START || number > Constants.NUMBER_RANGE_END) {
                throw new IllegalArgumentException(LottoError.RANGE.message());
            }
        }
    }

    public static Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END, Constants.NUMBER_LENGTH));
    }

}
