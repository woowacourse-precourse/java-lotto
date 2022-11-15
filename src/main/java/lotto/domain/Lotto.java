package lotto.domain;

import static lotto.constant.Constant.ERROR_MESSAGE;
import static lotto.constant.Constant.LOTTO_SIZE;
import static lotto.constant.Constant.MAX_LOTTO_NUMBER;
import static lotto.constant.Constant.MIN_LOTTO_NUMBER;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlapNumbers(numbers);
        validateNumbersRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            System.out.println(ERROR_MESSAGE + "로또의 크기는 6자리 입니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlapNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            System.out.println(ERROR_MESSAGE + "로또 번호는 중복이 불가합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkRange(number);
        }
    }

    private void checkRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            System.out.println(ERROR_MESSAGE + "로또 번호는 1부터 45사이여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
