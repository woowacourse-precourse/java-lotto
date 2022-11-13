package lotto.domain;

import lotto.constant.LottoNumbers;
import lotto.exception.ExceptionPhrase;

import java.util.List;

import static lotto.constant.LottoNumbers.LOTTO_LENGTH;
import static lotto.exception.ExceptionPhrase.EXCEPTION_DUPLICATE_NUMBER;
import static lotto.exception.ExceptionPhrase.EXCEPTION_OUT_OF_RANGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        duplicate(numbers);
        lottoRange(numbers);
    }
    private void duplicate(List<Integer> numbers) {
        int numbersLength = (int) numbers.stream().distinct().count();
        if(numbers.size() != numbersLength) {
            throw new IllegalArgumentException(EXCEPTION_DUPLICATE_NUMBER.getMessage());
        }
    }

    private void lottoRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < 0 || number >45) {
                throw new IllegalArgumentException(EXCEPTION_OUT_OF_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
