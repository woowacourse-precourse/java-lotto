package lotto.model.lotto;

import lotto.model.statistics.LottoResult;
import lotto.model.winningnumbers.WinningNumbers;

import java.util.ArrayList;
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

    public LottoResult check(WinningNumbers winningNumbers) {
        // TODO 구현 필요
        return LottoResult.MISS;
    }

    public List<Integer> getNumbers() {
        // TODO 구현 필요
        return new ArrayList<>();
    }

    // TODO: 추가 기능 구현
}
