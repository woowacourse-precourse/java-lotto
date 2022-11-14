package lotto;

import ui.SystemMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static util.Constant.*;

/**
 * 발급되는 한 장의 로또의 정보를 담고있는 클래스
 * 6개의 로또 번호를 담고있는 리스트를 wrapping 하는 일급 컬렉션
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getUserLottoNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        isValidNumberOfNumbers(numbers);
        isUniqueNumbers(numbers);
        isInRangeNumbers(numbers);
    }

    private void isValidNumberOfNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(NOT_VALID_LENGTH_NUMBERS);
        }
    }

    private void isUniqueNumbers(List<Integer> winningNumbers) {
        List<Integer> uniqueNumbers = winningNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (uniqueNumbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    private static void isInRangeNumbers(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(NOT_IN_RANGE_NUMBER_INPUT);
            }
        }
    }
}
