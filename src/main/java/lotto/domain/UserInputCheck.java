package lotto.domain;

import lotto.util.Validation;

public class UserInputCheck {
    static String purchaseAmountCheck(String userInput) {
        try {
            Validation.isNumber(userInput);
            Validation.isHigherThanMinPrice(userInput);
            Validation.isItDivided(userInput);
        } catch (IllegalArgumentException err) {
            System.out.println(err);
        }
        return userInput;
    }
}
