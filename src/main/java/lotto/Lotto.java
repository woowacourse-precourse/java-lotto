package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = getSortedNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        isLengthSix(numbers);
        isNumbersDuplicated(numbers);
        isNumbersInValidRange(numbers);
    }

    private void isLengthSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMsg.LOTTO_NOT_SIX.getMessage());
        }
    }

    private void isNumbersDuplicated(List<Integer> numbers) {
        int distinctNumbers = (int)numbers.stream()
                                        .distinct()
                                        .count();
        if (numbers.size() != distinctNumbers) {
            throw new IllegalArgumentException(ErrorMsg.LOTTO_DUPLICATED.getMessage());
        }
    }

    private void isNumbersInValidRange(List<Integer> numbers) {
        boolean anyNumUnderOne = numbers.stream().anyMatch(i -> i < 1);
        boolean anyNumOverFortyFive = numbers.stream().anyMatch(i -> i > 45);
        if (anyNumUnderOne || anyNumOverFortyFive) {
            throw new IllegalArgumentException(ErrorMsg.LOTTO_OUT_OF_RANGE.getMessage());
        }
    }

    private List<Integer> getSortedNumbers(List<Integer> numbers) {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        Collections.sort(copiedNumbers);
        return copiedNumbers;
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return "[" + numbers.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(", ")) + "]";
    }
}
