package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String toStringLotto() {
        StringBuilder lotto = new StringBuilder("[");
        for (int n : this.numbers) {
            lotto.append(String.valueOf(n)).append(", ");
        }
        lotto = new StringBuilder(lotto.substring(0, lotto.length() - 2) + "]");
        return lotto.toString();
    }
}
