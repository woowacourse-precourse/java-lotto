package model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static constant.Config.ERROR;
import static constant.Config.MAX_NUMBER;
import static constant.Config.MIN_NUMBER;
import static constant.Config.NUMBER_COUNT;
import static constant.Config.RANGE_ERROR;

public class Lotto {
    private static final String SIZE_ERROR = String.format("%s 로또 번호는 %d개의 숫자여야 합니다.", ERROR, NUMBER_COUNT);
    private static final String DUPLICATE_ERROR = String.format("%s 로또 번호는 중복되지 않아야 합니다.", ERROR);
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateRange(number);
        }
    }

    private static void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }
}
