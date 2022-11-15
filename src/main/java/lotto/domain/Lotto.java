package lotto.domain;

import lotto.exception.ErrorHandler;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        isUnique(numbers);
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ErrorHandler.sizeOverException();
        }
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                ErrorHandler.numberUnCorrectException();
            }
        }
    }
    public void isUnique(List<Integer> numbers) {
        if (numbers.size()!=Arrays.asList(numbers.stream().distinct().toArray()).size()){
            ErrorHandler.mutualInputException();
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
