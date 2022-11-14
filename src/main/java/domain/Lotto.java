package domain;

import util.ExceptionMessage;
import util.LottoRule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumber(numbers);
        validateNumbersInRange(numbers);
        numbers = sortAscend(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LottoRule.NUMBER_OF_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_SIZE);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> checkedNumbers = new HashSet<>();
        for (int number : numbers) {
            if (checkedNumbers.contains(number)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER);
            }
            checkedNumbers.add(number);
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (number < LottoRule.START_INCLUSIVE || number > LottoRule.END_INCLUSIVE) {
                throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE);
            }
        }
    }

    private List<Integer> sortAscend(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int numberOfSameNumbers(List<Integer> winnerNumbers) {
        return (int) getNumbers().stream()
                .filter(winnerNumbers::contains)
                .count();
    }

    public boolean isContainBonusNumber(int number) {
        return numbers.contains(number);
    }

}
