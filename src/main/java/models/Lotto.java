package models;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateInRange(numbers);
        validateDuplication(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }
    }

    private void validateInRange(List<Integer> numbers) {

        boolean result = numbers.stream().allMatch(number -> number >= 1 && number <= 45);

        if (!result) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }

    }

    private void validateDuplication(List<Integer> numbers) {

        boolean result = numbers.size() == numbers.stream().distinct().count();

        if (!result) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다..");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
