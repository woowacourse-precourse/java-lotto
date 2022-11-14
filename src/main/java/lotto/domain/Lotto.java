package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final String EXCEPTION_MESSAGE_NO_SIX_NUMBER = "[ERROR] 복권번호는 %d자리 숫자입니다.";
    private static final String EXCEPTION_MESSAGE_DUPLICATED_NUMBER = "[ERROR] 중복된 복권번호가 있습니다.";
    private static final String EXCEPTION_MESSAGE_OVER_NUMBER_RANGE = "[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final int LOTTO_LOWER_NUMBER = 1;
    private static final int LOTTO_UPPER_NUMBER = 45;
    private static final int LOTTO_DIGIT = 6;
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
        if (numbers.size() != LOTTO_DIGIT) {
            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_NO_SIX_NUMBER, LOTTO_DIGIT));
        }
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> distinctNumber = new HashSet<>(numbers);
        if (distinctNumber.size() != LOTTO_DIGIT) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_DUPLICATED_NUMBER);
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        int numberInRange = (int) numbers.stream()
                .filter(unitNumber -> ((unitNumber >= LOTTO_LOWER_NUMBER) && (unitNumber <= LOTTO_UPPER_NUMBER)))
                .count();
        if (numberInRange != LOTTO_DIGIT) {
            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_OVER_NUMBER_RANGE,
                    LOTTO_LOWER_NUMBER, LOTTO_UPPER_NUMBER));
        }
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::containNumber)
                .count();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted().collect(Collectors.toList()).toString();

    }
}
