package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers){
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException();
        }
    }

}
