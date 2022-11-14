package lotto;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoRandomNumberFactory.LOTTO_COUNT;

public class Lotto {

    public static final int LOTTO_NUMBER_LENGTH_ZERO = 0;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumber(List<Integer> numbers) {
        validateEmpty(numbers);
        validateOverlap(numbers);
        validateNumberSize(numbers);
    }

    private void validateEmpty(List<Integer> numbers) {
        if (numbers.size() == LOTTO_NUMBER_LENGTH_ZERO) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
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
            if (number > LottoRandomNumberFactory.END_INCLUSIVE) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 범위를 벗어나 너무 큽니다");
            }
            if (number < LottoRandomNumberFactory.START_INCLUSIVE) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 범위를 벗어나 너무 작습니다");
            }
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자가 모자릅니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
