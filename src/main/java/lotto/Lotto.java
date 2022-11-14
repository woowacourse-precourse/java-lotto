package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException{
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUM.message);
        }
        Set<Integer> noDuplicate = new HashSet<>(numbers);
        if (noDuplicate.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_EXIST.message);
        }
    }

    public List<Integer> showNumbers() {
        return new ArrayList<>(numbers);
    }
}
