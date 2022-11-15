package lotto;

import lotto.ui.Message;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        try {
            validate(numbers);
            hasSameNumber(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.LOTTO_SIZE_ERROR);
        }
    }

    private void hasSameNumber(List<Integer> numbers) {
        Set<Integer> sameNumber = new HashSet<>(numbers);
        if (sameNumber.size() != 6) {
            throw new IllegalArgumentException(Message.LOTTO_OVERLAP_ERROR);
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
