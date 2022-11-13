package lotto.domain.game;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String lottoNumbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validateIntLottoNumbers(String lottoNumbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
