package lotto;

import java.util.List;

import static lotto.Application.*;

public class Lotto {
    private final List<Integer> numbers;

    private static ErrorMessage error;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersAreInRange(numbers);
        validateNumbersAreDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            error = ErrorMessage.SIZE;
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersAreInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                error = ErrorMessage.RANGE;
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumbersAreDuplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                checkNumbersAreDuplicate(numbers.get(i), numbers.get(j));
            }
        }
    }

    private void checkNumbersAreDuplicate(int number1, int number2) {
        if (number1 == number2) {
            error = ErrorMessage.DUPLICATE;
            throw new IllegalArgumentException();
        }
    }

    public boolean checkWinningNumberIsInLottoNumbers(int winningNumber) {

        return numbers.contains(winningNumber);
    }

    public List<Integer> getNumbers() {

        return numbers;
    }

    public ErrorMessage getError() {

        return error;
    }

    // TODO: 추가 기능 구현
}
