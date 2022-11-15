package lotto.commons;

import java.util.List;
import lotto.exception.ExceptionHandler;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        ExceptionHandler exception = new ExceptionHandler();
        exception.createLottoNumberException(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
