package lotto.controller;

import java.util.Arrays;
import java.util.regex.Pattern;
import lotto.constant.ValidationConstant;
import lotto.constant.ValidationMessage;
import lotto.model.Lotto;

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


    public static void validateWinningNum(String winningNum) throws IllegalArgumentException {
        validateWinningNumisNotInRange1to45(winningNum);
    }

    private static void validateWinningNumisNotInRange1to45(String winningNum) {
        boolean isInRange1to45 = Arrays.stream(winningNum.split(",")).allMatch(numString -> Pattern.matches(ValidationConstant.PATTERN_OF_IN_RANGE,numString));
        if (isInRange1to45) {
            return;
        }
        throw  new IllegalArgumentException(ValidationMessage.ERROR + ValidationMessage.NOT_IN_RANGE);
    }

    public static void validateBonusNum(String bonusNum) throws IllegalArgumentException {
        validateNotInRange1to45(bonusNum);
    }

    private static void validateNotInRange1to45(String bonusNum) {
        boolean isInRange1to45 = Pattern.matches(ValidationConstant.PATTERN_OF_IN_RANGE,bonusNum);
        if (isInRange1to45) {
            return;
        }
        throw new IllegalArgumentException(ValidationMessage.ERROR + ValidationMessage.NOT_IN_RANGE);
    }


}
