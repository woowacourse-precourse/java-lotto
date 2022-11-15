package lotto.domain;

import java.util.List;

import static lotto.application.util.inputvalidator.ErrorMessage.LOTTO_AUTO_PUBLISHER_LENGTH;
import static lotto.application.util.inputvalidator.ErrorMessage.LOTTO_AUTO_PUBLISHER_OVERLAP;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_AUTO_PUBLISHER_LENGTH.getErrorMessage());
        }
        else if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(LOTTO_AUTO_PUBLISHER_OVERLAP.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
