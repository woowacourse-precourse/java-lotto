package lotto.view;

import lotto.exception.BuyLottoFormatException;
import lotto.exception.BuyLottoMoneyFormat;

import java.util.regex.Pattern;

public final class InputBuyLottoView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final Integer THOUSAND = 1000;
    private static final Integer ZERO = 0;

    public String getValue() {
        String result = inputValue();
        validate(result);
        return result;
    }

    private void validate(String inputValue) {
        validateFormat(inputValue);
        validateMoneyFormat(inputValue);
    }

    private void validateFormat(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new BuyLottoFormatException();
        }
    }

    private void validateMoneyFormat(String inputValue) {
        int money = Integer.parseInt(inputValue);

        if (money % THOUSAND == ZERO && money / THOUSAND > ZERO) {
            throw new BuyLottoMoneyFormat();
        }
    }
}
