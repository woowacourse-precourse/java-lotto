package lotto;

import lotto.view.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        repeat(numbers);
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
                throw new IllegalArgumentException(ErrorMessage.lottoRepeatation.getValue());
            } else {
                inputNumber.add(eachNumber);
            }
        }
    }
}
