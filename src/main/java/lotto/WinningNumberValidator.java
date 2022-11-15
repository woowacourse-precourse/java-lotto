package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumberValidator {

    private static final int LENGTH_OF_LOTTO_NUMBERS = 6;

    public void validate(String winningNumbers) {
        try {
            this.validateContainsValidNumbersWithComma(winningNumbers);

            List<Integer> numbers = numbersOf(winningNumbers);
            this.validateCorrectLength(numbers);
            this.validateNoDuplicates(numbers);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] ,로 구분되는 6개의 1-45 사이의 숫자만 허용됩니다.");
        }
    }

    private List<Integer> numbersOf(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private void validateContainsValidNumbersWithComma(String winningNumbers) {
        // only accepts string like -> 1,2,3,4,5 (only numbers between 1-45)
        var regex = "^(([1-4][0-5]|[1-9]),)*([1-4][0-5]|[1-9])$";
        if (!winningNumbers.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCorrectLength(List<Integer> numbers) {
        if (numbers.size() != LENGTH_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);

        if (numbers.size() != noDuplicateNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
