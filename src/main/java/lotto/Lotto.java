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

    public boolean validateNumbersSize(List<Integer> numbers) {

        return numbers.size() == 6;
    }

    public boolean validateNumbersAreInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    public boolean validateNumbersAreDuplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (!checkNumbersAreDuplicate(numbers.get(i), i)) {
                return false;
            }
        }
        return true;
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

    public ErrorMessage getError() {

        return error;
    }

    // TODO: 추가 기능 구현
}
