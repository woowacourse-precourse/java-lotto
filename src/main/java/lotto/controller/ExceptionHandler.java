package lotto.controller;

import java.util.regex.Pattern;
import lotto.constant.ValidationConstant;
import lotto.constant.ValidationMessage;

public class ExceptionHandler {

    public static void validateInputPriceOfString(String inputPrice) throws IllegalArgumentException{
        validateInputPriceIsNumOnly(inputPrice);
        validateInputPriceIsMultipleOf1000(inputPrice);
    }

    private static void validateInputPriceIsMultipleOf1000(String inputPrice) {
        boolean isMatchWithPattern = Pattern.matches(ValidationConstant.PATTERN_OF_1000_MULTI_REGEX,inputPrice);
        if (isMatchWithPattern) {
            return;
        }
        throw new IllegalArgumentException(ValidationMessage.ERROR + ValidationMessage.NOT_1000_MULTI);
    }

    private static void validateInputPriceIsNumOnly(String inputPrice) {
        boolean isMatchWithPattern = Pattern.matches(ValidationConstant.PATTERN_OF_NUM_REGEX,inputPrice);
        if (isMatchWithPattern) {
            return;
        }
        throw new IllegalArgumentException(ValidationMessage.ERROR + ValidationMessage.NOT_NUM);
    }



}
