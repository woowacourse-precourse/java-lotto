package lotto.view;

import lotto.exception.InvalidLottoInputFormatException;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class inputWinningLottoView extends inputView {
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");

    public String getValue() {
        String result = inputValue();
        validate(result);
        return result;
    }

    private void validate(String inputValue) {
        validateInput(inputValue);
        validateRangeNumbers(inputValue);
    }

    private void validateInput(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new InvalidLottoInputFormatException();
        }
    }

    private void validateRangeNumbers(String inputValue) {
        List<Integer> numbers = Stream.of(inputValue.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numbers.forEach(this::validateRange);
    }
}
