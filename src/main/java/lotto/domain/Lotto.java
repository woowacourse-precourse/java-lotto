package lotto.domain;

import static lotto.utils.Constant.NUMBER_OF_LOTTO;
import static lotto.utils.Validation.validateNumberInLottoRange;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import lotto.utils.ExceptionType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateBySize(numbers);
        validateNumbersByRange(numbers);
        validateByOverlap(numbers);
    }

    private void validateBySize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException(ExceptionType.OVER_THAN_NUMBER_OF_LOTTO.getMessage());
        }
    }

    private void validateNumbersByRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberInLottoRange(number);
        }
    }

    private void validateByOverlap(List<Integer> numbers) {
        HashSet<Integer> checkNumbers = new HashSet<>(numbers);

        if (checkNumbers.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException(ExceptionType.HAVE_OVERLAP.getMessage());
        }
    }

    private PriorityQueue<Integer> sort() {
        PriorityQueue<Integer> sortingNumbers = new PriorityQueue<>(Comparator.naturalOrder());
        sortingNumbers.addAll(numbers);
        return sortingNumbers;
    }

    @Override
    public String toString() {
        PriorityQueue<Integer> sortingNumbers = sort();

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while(sortingNumbers.size() > 1) {
            builder.append(sortingNumbers.poll()).append(", ");
        }
        builder.append(sortingNumbers.poll()).append("]");

        return builder.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
