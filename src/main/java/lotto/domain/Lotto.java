package lotto.domain;

import java.util.List;

import static lotto.domain.Validate.*;

public class Lotto {
    public static final int LOTTO_NUMS_SIZE = 6;
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMS_SIZE) {
            throw new IllegalArgumentException();
        }
        if (!isInRangeAll(numbers)) {
            throw new IllegalArgumentException("[ERROR] 자동으로 생성된 로또 번호의 범위가 올바르지 않습니다.");
        }
        if (!isNotDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 자동으로 생성된 로또 번호 중 중복되는 숫자가 있습니다.");
        }
    }
}
