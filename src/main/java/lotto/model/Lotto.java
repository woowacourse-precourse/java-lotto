package lotto.model;

import static lotto.utils.ConstantUtil.ERROR;
import static lotto.utils.ConstantUtil.LOTTO_NUMBER_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final String SIZE_ERROR_MESSAGE = ERROR + "로또 번호의 개수는 6개이어야 합니다.";
    private static final String DUPLICATES_ERROR_MESSAGE = ERROR + "로또 번호에 중복된 숫자가 있습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        sort(copyNumbers);
        this.numbers = copyNumbers;
    }

    public boolean isMatch(Bonus bonus) {
        return bonus.isMatch(numbers);
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        return (int) this.numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    public boolean isExistNumber(int number) {
        return numbers.contains(number);
    }

    private void sort(List<Integer> numbers) {
        Collections.sort(numbers);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
