package lotto;

import lotto.Enum.Errors;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Errors.NOT_CORRECT_SIZE.getName());
        }
        checkDuplicatedNumber(numbers);
        isCorrectRange(numbers);
    }

    private void isCorrectRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if(num < 0 || num > 45) {
                throw new IllegalArgumentException(Errors.NOT_CORRECT_RANGE.getName());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> targetset = new HashSet<>(numbers);
        if(targetset.size() != 6) {
            // 중복되는 숫자가 존재. -> 예외처리
            throw new IllegalArgumentException(Errors.IS_NOT_UNIQUE.getName());
        }
    }

    public void printSortedNumbers() {
        System.out.println(numbers);
    }
}
