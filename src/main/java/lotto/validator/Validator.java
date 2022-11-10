package lotto.validator;

import lotto.common.Error;

public class Validator {

    public void isValidPrice(String in) {
        isNumber(in, Error.NUMBER);
        require(Integer.parseInt(in) < 1000, Error.MINUS);
        require(Integer.parseInt(in) % 1000 != 0, Error.THOUSAND);
    }

    private void require(final boolean condition, final Error error) {
        if (condition) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }

    private void isNumber(String in, Error error) {
        try {
            Integer.parseInt(in);
        } catch (Exception e) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }
}
