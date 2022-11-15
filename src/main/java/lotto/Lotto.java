package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public final int LOTTO_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            Error.ILLEGAL_LOTTO_LENGTH.wrongInput();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> checkDuplicate = new HashSet<Integer>();

        for (int n: numbers) {
            if (!checkDuplicate.add(n)){
                Error.LOTTO_NUM_DUPLICATE_ERROR.wrongInput();
            }
        }
    }
}
