package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Constants.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.checkLottoSize(numbers);
        Validator.checkDuplicate(numbers);
        Validator.checkOutOfRange(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
