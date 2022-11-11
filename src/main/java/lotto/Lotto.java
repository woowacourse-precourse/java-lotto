package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static util.Constant.NUMBER_OF_NUMBERS;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidNumberOfNumbers(numbers);
        isUniqueNumbers(numbers);
        isInRangeNumbers(numbers);
    }

    private void isValidNumberOfNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.");
        }
    }

    private void isUniqueNumbers(List<Integer> winningNumbers) {
        List<Integer> uniqueNumbers = winningNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (uniqueNumbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private static void isInRangeNumbers(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 범위의 숫자여야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getUserLottoNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }
}
