package lotto.model;

import java.util.List;

import static lotto.utils.ExceptionMessage.LOTTO_NUMBERS_NOT_SIX;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NOT_SIX);
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }


}
