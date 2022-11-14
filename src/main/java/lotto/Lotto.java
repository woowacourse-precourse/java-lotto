package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.validator.LottoValidator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberSize(numbers);
        validateDuplicateNumber(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return Collections.unmodifiableList(sortedNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
