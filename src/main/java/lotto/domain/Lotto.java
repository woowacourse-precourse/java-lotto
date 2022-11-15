package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String DELIMITER = ",";
    private static final int NUMBERS_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(String numbers) {
        this(Arrays.stream(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int compare(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        List<Integer> other = new ArrayList<>(lotto.numbers);
        numbers.retainAll(other);
        return numbers.size();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_COUNT || distinct(numbers).size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자로 이뤄져야 합니다.");
        }
        numbers.forEach(this::validateRange);
    }

    private List<Integer> distinct(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private void validateRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복되었습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
