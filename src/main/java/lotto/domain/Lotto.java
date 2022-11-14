package lotto.domain;

import static lotto.domain.SystemMessage.ERROR_MESSAGE;
import static lotto.domain.SystemMessage.SIZE_ERROR_MESSAGE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + SIZE_ERROR_MESSAGE);
        }
    }


    public List<Integer> getLotto(){
        return numbers;
    }
}
