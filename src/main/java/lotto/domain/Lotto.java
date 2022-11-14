package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private static final int SIZE_OF_NUMBERS = 6;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final String SIZE_ERROR = "[ERROR] 6개의 숫자가 아닙니다.";
    private static final String RANGE_ERROR = "[ERROR] 숫자가 범위를 벗어납니다.";
    private static final String DUPLICATE_ERROR = "[ERROR] 중복된 숫자가 존재합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void printNumbers() {
        List<Integer> numbersForSort = new ArrayList<>(numbers);
        numbersForSort.sort(Comparator.naturalOrder());
        System.out.println(numbersForSort);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(SIZE_ERROR);
            throw new IllegalArgumentException();
        }
        if (!areInRange(numbers)) {
            System.out.println(RANGE_ERROR);
            throw new IllegalArgumentException();
        }
        if (areDuplicate(numbers)) {
            System.out.println(DUPLICATE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private boolean areInRange(List<Integer> numbers) {
        boolean inRange = true;
        int index = 0;
        while (inRange && index < SIZE_OF_NUMBERS) {
            int number = numbers.get(index);
            inRange = isInRange(number);
            index++;
        }
        return inRange;
    }

    private boolean isInRange(int number) {
        return number >= MINIMUM_NUMBER && number <= MAXIMUM_NUMBER;
    }

    private boolean areDuplicate(List<Integer> numbers) {
        boolean duplicate = false;
        int index = 0;
        while (!duplicate && index < SIZE_OF_NUMBERS) {
            int number = numbers.get(index);
            duplicate = isDuplicate(numbers, number, index+1);
            index++;
        }
        return duplicate;
    }

    private boolean isDuplicate(List<Integer> numbers, int number, int start) {
        boolean duplicate = false;
        while (!duplicate && start < SIZE_OF_NUMBERS) {
            int compareNumber = numbers.get(start);
            duplicate = areSame(number, compareNumber);
            start++;
        }
        return duplicate;
    }

    private boolean areSame(int number, int compareNumber) {
        return number == compareNumber;
    }
}
