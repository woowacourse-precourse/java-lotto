package lotto.domain;

import static lotto.view.SystemMessage.DUPLICATE_ERROR_MESSAGE;
import static lotto.view.SystemMessage.ERROR_MESSAGE;
import static lotto.view.SystemMessage.SIZE_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNumberDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateLottoNumberDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateChecker = new HashSet<>(numbers);
        if (duplicateChecker.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_ERROR_MESSAGE);

        }
    }


    public List<Integer> getLotto(){
        return numbers;
    }
}
