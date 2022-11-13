package lotto;

import java.util.List;

public class Lotto {

    public static final int NUMBER_COUNT = 6;
    public static final int NUMBER_RANGE_START = 1;
    public static final int NUMBER_RANGE_END = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNonDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            System.out.println("[ERROR] 6개의 숫자를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateNonDuplicate(List<Integer> numbers) {
        for (int number : numbers) {
            if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                System.out.println("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!isInRange(number)) {
                System.out.println("[ERROR] 1 ~ 45 사이의 숫자만 입력할 수 있습니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public static boolean isInRange(int number) {
        return NUMBER_RANGE_START <= number && number <= NUMBER_RANGE_END;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
