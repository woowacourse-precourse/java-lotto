package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLengthOfNumbers(numbers);
        validateDuplicationOfNumbers(numbers);
        validateRangeOfNumbers(numbers);
    }

    private void validateLengthOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private  void validateDuplicationOfNumbers(List<Integer> numbers) {
        int[] checkDuplication = new int[46];
        for(Integer number : numbers){
            if (checkDuplication[number] == 1) {
                throw new IllegalArgumentException();
            }
            checkDuplication[number] = 1;
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
