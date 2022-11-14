package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.exception.NumberOutOfRangeException;
import lotto.exception.NumbersDuplicatedException;
import lotto.exception.NumbersNotMatchDigitException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int checkRank(List<Integer> winningNumbers, int bonusNumber) {
        int count = 0;

        count += winningNumbers.stream()
                .filter(numbers::contains)
                .count();

        if (count == 5 && numbers.contains(bonusNumber)) {
            count = 7;
        }

        return count;
    }

    private void validate(List<Integer> numbers){
        validateNumbersMatchDigit(numbers);
        validateNumberDuplicated(numbers);
        validateNumbersOutOfRange(numbers);
    }

    private void validateNumberDuplicated(List<Integer> numbers){
        if(numbers.stream().anyMatch(number -> Collections.frequency(numbers, number) > 1)){
            throw new NumbersDuplicatedException();
        }
    }
    private void validateNumbersMatchDigit(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new NumbersNotMatchDigitException();
        }
    }

    private void validateNumbersOutOfRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new NumberOutOfRangeException();
        }
    }
}
