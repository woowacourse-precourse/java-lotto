package lotto;

import java.util.List;
import lotto.controller.ExceptionHandler;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ExceptionHandler.validateWinNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개여야 합니다.");
        }
    }
    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
