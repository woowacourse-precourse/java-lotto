package lotto.domain;

import java.util.List;

import static lotto.util.NumericProperties.MAX_NUM;
import static lotto.util.NumericProperties.MIN_NUM;
import static lotto.util.NumericProperties.SIZE;
import static lotto.util.message.ExceptionMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != SIZE.get()) {
            throw new IllegalArgumentException(WRONG_SIZE.get());
        }
        for (Integer num : numbers) {
            if (num < MIN_NUM.get() || num > MAX_NUM.get()) {
                throw new IllegalArgumentException(OUT_OF_SCOPE.get());
            }
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(DUPLICATED.get());
        }
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
