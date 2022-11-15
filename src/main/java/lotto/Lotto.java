package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MAXIMUM_NUMBER_OF_LOTTO = 45;
    private static final int MINIMUM_NUMBER_OF_LOTTO = 1;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateRange(List<Integer> numbers) {
        for(Integer number : numbers){
            if(MAXIMUM_NUMBER_OF_LOTTO > number || MINIMUM_NUMBER_OF_LOTTO < number)
                throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count())
            throw new IllegalArgumentException();
    }
}
