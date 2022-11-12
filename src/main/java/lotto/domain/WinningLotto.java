package lotto.domain;

import java.util.List;

import static lotto.service.Validation.*;

public class WinningLotto extends Lotto {

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    private void validate(List<Integer> numbers) {
        boolean chk = numbers.stream()
                .allMatch(x -> isInRange(1, x, 45));

        if (!(numbers.size() == 6 && chk)) {
            throw new IllegalArgumentException();
        }
    }
}
