package lotto.view;

import lotto.exception.BuyLottoFormatException;

import java.util.regex.Pattern;

public final class InputBuyLottoView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public String getValue() {
        String result = inputValue();
        validate(result);
        return result;
    }

    private void validate(String inputValue) {
        validateFormat(inputValue);
    }

    private void validateFormat(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new BuyLottoFormatException();
        }
    }
}
