package lotto.controller;

import lotto.ErrorMessage;

import java.util.regex.Pattern;

public class ValidationException {

    public static boolean checkValidPrice(String userMoney) {
        String regExp = "^[1-9]+0{3}$";

        if (Pattern.matches(regExp, userMoney)) {
            return true;
        }
        throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.ERROR_MESSAGE_WON);
    }
}
