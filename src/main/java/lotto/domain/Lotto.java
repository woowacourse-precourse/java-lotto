package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Errors.LENGTH.getMessage());
        }
        check1Between45(numbers);
        checkOverlap(numbers);
    }

    private void check1Between45(List<Integer> numbers){
        for (Integer num : numbers){
            if (num < 1 || num > 45){
                throw new IllegalArgumentException(Errors.ONE_BETWEEN_NINE.getMessage());
            }
        }
    }

    private void checkOverlap(List<Integer> numbers){
        if (new HashSet<Integer>(numbers).size() != numbers.size()){
            throw new IllegalArgumentException(Errors.OVERLAP.getMessage());
        }
    }
}
