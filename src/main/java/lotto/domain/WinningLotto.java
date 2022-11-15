package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.ExceptionMessage.INVALID_SEPARATOR;
import static lotto.utils.Validation.*;

public class WinningLotto {
    private final List<Integer> numbers;

    public WinningLotto(String winningNumbers) {
        this.numbers = validate(winningNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> validate(String input) {
        validateNull(input);
        validateSeparator(input);
        List<Integer> winningNumbers = separateInput(input);
        validateSize(winningNumbers);
        validateRange(winningNumbers);

        return winningNumbers;
    }

    private void validateSeparator(String input) {
        if (!input.matches("^[\\d,]*$")) {
            throw new IllegalArgumentException(INVALID_SEPARATOR.getMessage());
        }
    }

    private List<Integer> separateInput(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
