package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getSortedLottoNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        Validator validator = new Validator();

        validator.validateNumberSize(numbers);
        validator.validateDuplicateNumber(numbers);
        validator.validateNumberRange(numbers);
    }
}
