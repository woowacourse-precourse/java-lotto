package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String NOT_SIX_NUMBER_EXCEPTION_MESSAGE = "복권번호는 6자리 숫자입니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION_MESSAGE = "중복된 복권번호가 있습니다.";
    private static final String OVER_RANGE_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSixNumber(numbers);
        checkDuplicatedNumber(numbers);
        checkNumberRange(numbers);
    }

    // TODO: 추가 기능 구현
    private void checkSixNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidInputException(NOT_SIX_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> distinctNumber = new HashSet<>(numbers);
        if (distinctNumber.size() != 6) {
            throw new InvalidInputException(DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        int numberInRange = (int) numbers.stream()
                .filter(unitNumber -> ((unitNumber >= 1) && (unitNumber <= 45)))
                .count();
        if (numberInRange != 6) {
            throw new InvalidInputException(OVER_RANGE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
