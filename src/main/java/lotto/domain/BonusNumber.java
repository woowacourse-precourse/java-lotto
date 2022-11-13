package lotto.domain;

import lotto.utils.Constant;
import lotto.utils.ErrorMessage;

import java.util.Arrays;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String input) {
        validateCheckNumeric(input);
        validateFirstNumberIsNotZero(input);
        bonusNumber = Integer.parseInt(input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateCheckNumeric(String input) {
        String[] split = input.split(Constant.REGEX_INPUT);

        if (!Arrays.stream(split).allMatch(number -> number.charAt(0) >= '0' && number.charAt(0) <= '9'))
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INPUT_MUST_NUMBER);
    }

    private void validateFirstNumberIsNotZero(String input) {
        String[] split = input.split(Constant.REGEX_INPUT);

        if (split.length > 1 && split[0].equals("0"))
            throw new IllegalArgumentException(ErrorMessage.FIRST_NUMBER_IS_NOT_ZERO);
    }
}
