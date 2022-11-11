package lotto;


import java.util.List;

import static lotto.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkLottoByDuplicatedNumber(numbers);
        checkLottoNumberOver45(numbers);

        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(MORE_THAN_SIX_LOTTO.getStatus());
        }
    }


    private void checkLottoByDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO.getStatus());
        }
    }


    // TODO: 추가 기능 구현
    private void checkLottoNumberOver45(List<Integer> numbers) {
        for (int num : numbers) {
            if (num > 45 || num < 1) throw new IllegalArgumentException(ABOVE_ELEMENT.getStatus());
        }
    }
}
