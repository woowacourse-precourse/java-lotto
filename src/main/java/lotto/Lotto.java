package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }

        HashSet<Integer> numbersNotDuplicate = new HashSet<>();
        numbersNotDuplicate.addAll(numbers);
        if (numbersNotDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }

        if (numbers.get(0) < 1 || numbers.get(5) > 45) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    private void sortNumbers(List<Integer> numbers){
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }





    // TODO: 추가 기능 구현
}
