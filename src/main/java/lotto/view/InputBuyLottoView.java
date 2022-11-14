package lotto.view;

import lotto.exception.BuyLottoException;

import java.util.regex.Pattern;

public final class InputBuyLottoView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("\\d+0{3}");

    public String getValue() {
        String result = inputValue();
        validate(result);
        return result;
    }

    private void validate(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new BuyLottoException();
        }
    }
}
