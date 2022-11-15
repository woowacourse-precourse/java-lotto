package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        raiseErrorIfNotMatchNumberSize(numbers, 6);
        raiseErrorIfDuplicatedElement(numbers);
    }

    private void raiseErrorIfNotMatchNumberSize(List<Integer> numbers, Integer mustBe) {
        if (numbers.size() != mustBe) {
            throw new IllegalArgumentException("[ERROR] 길이가 " + mustBe.toString() + "이 아닙니다.");
        }
    }

    private void raiseErrorIfDuplicatedElement(List<Integer> numbers) {
        if (hasDuplicatedElement(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    private boolean hasDuplicatedElement(List<Integer> numbers) {
        int size = numbers.size();
        for (int i = 0; i < size; ++i) {
            if (numbers.subList(i+1, size).contains(numbers.get(i))) {
                return true;
            }
        }
        return false;
    }

    public Integer compare(Lotto other) {
        try {
            return compareTwoNumbers(numbers, other.getNumbers());
        } catch (IndexOutOfBoundsException e) {
            logError(e);
        }
        return 0;
    }

    private Integer compareTwoNumbers(List<Integer> target, List<Integer> source) {
        return countEqualElement(target, source);
    }

    private Integer countEqualElement(List<Integer> target, List<Integer> source) {
        int size = source.size();
        Integer count = 0;
        for (int i : source) {
            if (target.contains(i)) {
                ++count;
            }
        }
        return count;
    }

    private void logError(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
