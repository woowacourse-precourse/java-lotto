package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || validate) {
            throw new IllegalArgumentException();
        }
    }
}
