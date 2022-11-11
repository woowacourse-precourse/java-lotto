package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.ErrorMessage.DUPLICATED_LOTTO;
import static lotto.ErrorMessage.MORE_THAN_SIX_LOTTO;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkLottoByDuplicatedNumber(numbers);
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
}
