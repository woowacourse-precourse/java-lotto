package lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static lotto.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
        if (false) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
        if (false) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    public void sortNumbers(){
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }





    // TODO: 추가 기능 구현
}
