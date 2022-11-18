package lotto;

import lotto.exception.UIException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        UIException uiException = new UIException();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
        }

        uiException.duplicateNumberException(numbers);
        uiException.overBoundaryException(numbers);
    }

    public List<Integer> GetLottoNumber() {
        return numbers;
    }
}
