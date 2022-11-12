package lotto.utils;

import java.util.Arrays;

public class InputValidation {

    public void checkNumber(String input, String splitRegex) {
        String[] split = input.split(splitRegex);

        boolean result = Arrays.stream(split).allMatch((alphbet) -> alphbet.charAt(0) >= '0' && alphbet.charAt(0) <= '9');
        if (!result)
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INPUT_MUST_NUMBER);
    }

    public void checkThousandMoney(String input) {
        int price = Integer.parseInt(input);

        if (price % Constant.LOTTO_PRICE != 0)
            throw new IllegalArgumentException(ErrorMessage.LOTTO_MUST_THOUSAND_PRICE);
    }

}