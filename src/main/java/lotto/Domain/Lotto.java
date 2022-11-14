package lotto.Domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int purchase;

    public Lotto(List<Integer> numbers) {
        sizeValidate(numbers);
        duplicationValidate(numbers);
        this.numbers = numbers;
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicationValidate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i != numbers.indexOf(i)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
