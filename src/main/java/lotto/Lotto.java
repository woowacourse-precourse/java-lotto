package lotto;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoFactory.LOTTO_COUNT;

public class Lotto {

    public static final int LOTTO_NUMBER_LENGTH_ZERO = 0;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateLottoNumber(numbers);
    }

    private List<Integer> validateLottoNumber(List<Integer> numbers) {
        validateEmpty(numbers);
        validateCount(numbers);
        validateOverlap(numbers);
        validateNumberSize(numbers);
        Collections.sort(numbers);
        return numbers;
    }

    private void validateEmpty(List<Integer> numbers) {
        if (numbers.size() == LOTTO_NUMBER_LENGTH_ZERO) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자가 모자릅니다.");
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> overlapCheck = new LinkedHashSet<>(numbers);
        if (overlapCheck.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 중복 숫자가 있습니다.");
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > LottoFactory.END_INCLUSIVE) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 범위를 벗어나 너무 큽니다");
            }
            if (number < LottoFactory.START_INCLUSIVE) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 범위를 벗어나 너무 작습니다");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
