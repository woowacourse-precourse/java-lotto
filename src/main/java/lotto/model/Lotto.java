package lotto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static lotto.constant.LottoConstant.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortByAsc();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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

    public int countNumberOfMatch(Lotto comparedLotto) {
        int numberOfMatch = 0;
        for (Integer number : comparedLotto.numbers) {
            if (this.numbers.contains(number)) numberOfMatch++;
        }
        return numberOfMatch;
    }

    public boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoRange(numbers);
        validateDuplication(numbers);
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_NUMBER_RANGE_MIN || number > LOTTO_NUMBER_RANGE_MAX) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> comparedNumbers = numbers.subList(i + 1, numbers.size());
            Integer number = numbers.get(i);
            if (comparedNumbers.contains(number)) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_DUPLICATION);
            }
        }
    }

    private void sortByAsc() {
        numbers.sort(Comparator.naturalOrder());
    }
}
