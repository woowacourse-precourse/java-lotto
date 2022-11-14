package lotto.view;

import lotto.exception.InvalidLottoInputFormatException;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputWinningLottoView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");
    private static final String INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public List<Integer> getValue() {
        System.out.println(INPUT_MESSAGE);
        String result = inputValue();
        validate(result);
        return Stream.of(result.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate(String inputValue) {
        validateInput(inputValue);
    }

    private void validateInput(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new InvalidLottoInputFormatException();
        }
    }
}
