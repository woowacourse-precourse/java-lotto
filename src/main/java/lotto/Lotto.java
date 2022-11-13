package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Application.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validateNumbersSize();
        validateNumbersAreInRange();
        validateNumbersAreDuplicate();
    }

    private void validateNumbersSize() {
        if (numbers.size() != 6) {
            setError(ErrorMessage.SIZE);
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersAreInRange() {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                setError(ErrorMessage.RANGE);
                throw new IllegalArgumentException();
            }
        }

    }

    private void validateNumbersAreDuplicate() {
        List<Integer> validateNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (validateNumbers.contains(number)) {
                setError(ErrorMessage.DUPLICATE);
                throw new IllegalArgumentException();
            }
            validateNumbers.add(number);
        }
    }

    public boolean checkWinningNumberIsInLottoNumbers(int winningNumber) {

        return numbers.contains(winningNumber);
    }

    public List<Integer> getNumbers() {

        return numbers;
    }

    // TODO: 추가 기능 구현
}
