package lotto;

import lotto.constant.LottoNumbers;
import lotto.exception.ExceptionPhrase;

import java.util.List;

import static lotto.constant.LottoNumbers.LOTTO_LENGTH;
import static lotto.exception.ExceptionPhrase.EXCEPTION_DUPLICATE_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH.getNumber()) {
            throw new IllegalArgumentException();
        }
        duplicate(numbers);
    }
    private void duplicate(List<Integer> numbers) {
        int numbersLength = (int) numbers.stream().distinct().count();
        if(numbers.size() != numbersLength) {
            throw new IllegalArgumentException(EXCEPTION_DUPLICATE_NUMBER.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
