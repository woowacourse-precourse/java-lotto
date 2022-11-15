package lotto;

import lotto.console.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        repeat(numbers);
        range(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.lottoIndex.getValue());
        }
    }
    private void repeat(List<Integer> numbers) {
        List<Integer> inputNumber = new ArrayList<>();
        for (int eachNumber : numbers) {
            if (inputNumber.contains(eachNumber)) {
                throw new IllegalArgumentException(ErrorMessage.lottoRepetition.getValue());
            } else {
                inputNumber.add(eachNumber);
            }
        }
    }
    private void range(List<Integer> numbers) {
        for (int eachNumber : numbers) {
            if ( eachNumber < 1 || eachNumber > 45) {
                throw new IllegalArgumentException(ErrorMessage.lottoRange.getValue());
            }
        }
    }
}
