package lotto.Domain;

import lotto.Input.PrintError;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSix(numbers);
        validateOverlap(numbers);
        validateOutOfRange(numbers);
        this.numbers = numbers;
    }

    private void validateSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(PrintError.NO_SIX_NUM.getMessage());
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> compareNum = new HashSet<>(numbers);

        if(numbers.size() != compareNum.size()) {
            throw new IllegalArgumentException(PrintError.OVERLAP.getMessage());
        }
    }

    private void validateOutOfRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number<1 || 45<number) {
                throw new IllegalArgumentException(PrintError.OUT_OF_NUMBER_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
