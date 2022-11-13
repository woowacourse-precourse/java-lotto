package lotto.Domain;

import Utils.InputUtils;
import Utils.RandomUtils;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        final String ERROR_MESSAGE = "[ERROR] 중복하지 않는 6개의 숫자를 입력해야 합니다.";
        if (!InputUtils.isNumberLengthSix(numbers) || !RandomUtils.isUniqueNumber(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }
}
