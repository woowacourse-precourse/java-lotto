package lotto.view;

import lotto.exception.InvalidLottoInputFormatException;

import java.util.regex.Pattern;

public class inputWinningLottoView extends inputView {
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2}[,]){5}\\d{1,2}");

    public String getValue() {
        String result = inputValue();
        validate(result);
        return result;
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
