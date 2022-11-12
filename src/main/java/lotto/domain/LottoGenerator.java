package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.exception.NumberOutOfRangeException;
import lotto.exception.NumbersDuplicatedException;
import lotto.exception.NumbersNotMatchDigitException;

public class LottoGenerator {

    public List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validateLottoNumbers(numbers);
        return numbers;
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        validateNumbersMatchDigit(numbers);
        validateNumberDuplicated(numbers);
        validateNumbersOutOfRange(numbers);
    }

    private void validateNumberDuplicated(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> Collections.frequency(numbers, number) > 1)) {
            throw new NumbersDuplicatedException();
        }
    }

    private void validateNumbersMatchDigit(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new NumbersNotMatchDigitException();
        }
    }

    private void validateNumbersOutOfRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new NumberOutOfRangeException();
        }
    }
}
