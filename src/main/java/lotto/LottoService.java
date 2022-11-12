package lotto;

import java.util.List;
import constant.*;

import static constant.LottoNumber.REQUIRE_LOTTO_NUMBER_COUNT;

public class LottoService {
    private final List<Integer> numbers;

    public LottoService(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() !=REQUIRE_LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }

    }

    // TODO: 추가 기능 구현
}
