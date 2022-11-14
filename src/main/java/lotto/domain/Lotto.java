package lotto.domain;

import lotto.view.Message;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validateSize();
        validateDuplicate();
        validateRange();

    }

    private void validateSize() {
        if (numbers.size() != Resource.LOTTO_SIZE) {
            throw new IllegalArgumentException(Message.LOTTO_NOTSIZE);
        }
    }

    private void validateDuplicate() {
        int numbersLength = (int) numbers.stream()
                .distinct()
                .count();
        if (numbersLength != Resource.LOTTO_SIZE) {
            throw new IllegalArgumentException(Message.LOTTO_DUPLICATE);
        }
    }

    private void validateRange() {
        for (int number : numbers) {
            if (number < Resource.MIN_LOTTO_NUMBER || number > Resource.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(Message.LOTTO_NOTRANGE);
            }
        }
    }


}
