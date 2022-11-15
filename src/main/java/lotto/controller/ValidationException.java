package lotto.controller;

import lotto.constants.ErrorMessage;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constants.ErrorMessage.*;

public class ValidationException {

    public static boolean checkValidPrice(String userMoney) {
        String regExp = "^[1-9]\\d*0{3}$";

        if (Pattern.matches(regExp, userMoney)) {
            return true;
        }
        throw new IllegalArgumentException(ERROR + ERROR_MESSAGE_WON);
    }

    public static boolean checkValidTargetNumber(String targetInput) {
        String regExp = "[1-9]|[1-3]\\d|4[0-5]";
        for (String input : targetInput.split(",")) {
            if (!Pattern.matches(regExp, input)) {
                throw new IllegalArgumentException(ERROR + ERROR_MESSAGE_TARGET);
            }
        }
        return true;
    }
}
