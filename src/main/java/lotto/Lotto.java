package lotto;

import java.util.List;

import static lotto.LottoFactory.LOTTO_MAX_NUMBER;
import static lotto.LottoFactory.LOTTO_MIN_NUMBER;
import static lotto.Money.BLANK;
import static lotto.WinningNumber.REPEAT_INITIAL_VALUE;

public class Lotto {

    private static final int LOTTO_DEFAULT_LENGTH = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        for (int i = REPEAT_INITIAL_VALUE; i < numbers.size(); i++) {
            validateBlank(i, numbers);
            validateLottoNumberRange(i, numbers);
        }
        validateLength(numbers);
    }

    private void validateBlank(int initialValue, List<Integer> numbers) {
        if (String.valueOf(numbers.get(initialValue)).equals(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 숫자에 공백이 포함되어 있습니다.");
        }
    }

    private void validateLottoNumberRange(int initialValue, List<Integer> numbers) {
        if (numbers.get(initialValue) < LOTTO_MIN_NUMBER || numbers.get(initialValue) < LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자 범위를 벗어났습니다.");
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_DEFAULT_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 길이가 올바르지 않습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
