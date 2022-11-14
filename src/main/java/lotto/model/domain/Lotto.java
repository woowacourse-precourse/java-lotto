package lotto.model.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final String LEFT_BRACKETS = "[";
    private static final String RIGHT_BRACKETS = "]";
    private static final String NUMBER_SEPARATOR = ", ";
    private static final String NEW_LINE = "\n";
    private static final String WRONG_NUMBER_SIZE = "로또 번호 숫자는 6개 입니다.";
    private static final String DUPLICATED_NUMBER = "로또 번호는 중복되지 않아야 합니다.";
    private static final String INVALID_NUMBER_RANGE = "로또 번호는 1이상 45 이어야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateNumbers(List<Integer> numbers) {
        if (isInvalidLottoNumberSize(numbers)) {
            throw new IllegalArgumentException(WRONG_NUMBER_SIZE);
        }
        if (isInvalidAllLottoNumberRange(numbers)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
        if (hasDuplicatedLottoNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER);
        }
    }

    private boolean isInvalidLottoNumberSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_SIZE;
    }

    private boolean isInvalidAllLottoNumberRange(List<Integer> numbers) {
        return numbers.stream()
                .filter(this::isValidLottoNumberRange)
                .count() != LOTTO_NUMBER_SIZE;
    }

    private boolean isValidLottoNumberRange(int num) {
        return num >= LOTTO_NUMBER_MIN && num <= LOTTO_NUMBER_MAX;
    }

    private boolean hasDuplicatedLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != LOTTO_NUMBER_SIZE;
    }

    @Override
    public String toString() {
        String numbersToString = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(NUMBER_SEPARATOR));

        return LEFT_BRACKETS + numbersToString + RIGHT_BRACKETS + NEW_LINE;
    }

    int countMatch(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    boolean contains(int number) {
        return numbers.contains(number);
    }

}
