package lotto;

import java.util.List;

import static lotto.Application.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersAreInRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            printErrorAboutSize();
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersAreInRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                printErrorAboutRange();
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkNumbersAreDuplicate(int number1, int number2) {
        if (number1 == number2) {
            printErrorAboutDuplicate();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
