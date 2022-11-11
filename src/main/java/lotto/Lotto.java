package lotto;

import static lotto.utils.ConstantUtil.LOTTO_NUMBER_SIZE;
import static lotto.utils.ConstantUtil.MAX_LOTTO_NUMBER;
import static lotto.utils.ConstantUtil.MIN_LOTTO_NUMBER;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호의 개수는 6개이어야 합니다.";
    private static final String DUPLICATES_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호에 1 ~ 45 범위를 벗어난 숫자가 있습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getSortedLottoNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATES_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isNotValidRange(number)) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }

    private boolean isNotValidRange(int number) {
        return (!(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER));
    }
}
