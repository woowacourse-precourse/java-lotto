package lotto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.*;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        Validator.checkSize(numbers);
        Validator.checkUniqueness(numbers);
        numbers.forEach(number -> {
            Validator.checkRange(number);
        });
        lottoNumbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
