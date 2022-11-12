package lotto;

import java.util.List;

import static lotto.Application.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize();
        validateNumbersAreInRange();
        validateNumbersAreDuplicate();
        this.numbers = numbers;
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
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (!checkNumbersAreDuplicate(numbers.get(i), i)) {
                setError(ErrorMessage.DUPLICATE);
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean checkNumbersAreDuplicate(int number1, int index) {
        for (int i = index + 1; i < numbers.size(); i++) {
            if (number1 == numbers.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWinningNumberIsInLottoNumbers(int winningNumber) {

        return numbers.contains(winningNumber);
    }

    public List<Integer> getNumbers() {

        return numbers;
    }

    // TODO: 추가 기능 구현
}
