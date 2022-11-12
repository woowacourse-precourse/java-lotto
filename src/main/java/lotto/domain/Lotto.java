package lotto.domain;

import static lotto.domain.LottoValidator.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
}
