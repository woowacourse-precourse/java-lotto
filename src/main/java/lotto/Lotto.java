package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Valid.hasDuplicateNumber(numbers);
        Valid.hasCorrectSizeLotto(numbers);
    }

    // TODO: 추가 기능 구현
}
