package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSizeNumbers(numbers);
        checkNullNumbers(numbers);
        checkDuplicateNumber(numbers);
        checkSortedNumbers(numbers);
    }

    private void checkNullNumbers(final List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSizeNumbers(final List<Integer> numbers) {
        if (numbers.size() != LottoEnum.TOTAL_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSortedNumbers(final List<Integer> numbers) {
        int beforeNumber = numbers.get(0);
        for (final Integer number : numbers) {
            if (beforeNumber <= number) {
                beforeNumber = number;
                continue;
            }
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(final List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (numbers.lastIndexOf(number) == i) {
                continue;
            }
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
