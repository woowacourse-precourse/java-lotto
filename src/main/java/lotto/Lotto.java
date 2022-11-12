package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int _min_lotto_number = 1;
    private static final int _max_lotto_number = 45;
    private static final String _error_default_msg = "[ERROR]";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void show() {
        System.out.print(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isNumberNullOrEmpty(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!hasSixNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
        for (int num : numbers) {
            if (hasDuplicateNumber(numbers, num)) {
                throw new IllegalArgumentException();
            }
            if (!isNumberInRangeForLotto(num)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isNumberNullOrEmpty(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean hasSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            return false;
        }
        return true;
    }

    private boolean hasDuplicateNumber(List<Integer> numbers, Integer number) {
        if (Collections.frequency(numbers, number) != 1) {
            return true;
        }
        return false;
    }

    private boolean isNumberInRangeForLotto(int num) {
        if (num >= _min_lotto_number && num <= _max_lotto_number) {
            return true;
        }
        return false;
    }

    // TODO: 추가 기능 구현
}
