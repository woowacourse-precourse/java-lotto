package lotto.domain;

import lotto.domain.util.Validation;

public class UserInputCheck {
    static Integer purchaseAmountCheck(String userInput) {
        try {
            Validation.isNumber(userInput);
            Validation.isHigherThanMinPrice(userInput);
            Validation.isItDivided(userInput);
        } catch (IllegalArgumentException err) {
            System.out.println(err);
        }
        return Integer.parseInt(userInput);
    }

    static String winningNumberCheck(String userInput) {
        String[] numbers = userInput.split(",");
        try {
            Validation.isNumber(numbers);
            Validation.isValidLength(numbers);
            Validation.isItRange(numbers);
        }catch (IllegalArgumentException err){
            System.out.println(err);
        }
        return userInput;
    }

    static String bonusNumberCheck(String userInput){
        Validation.isNumber(userInput);
        Validation.isValidLength(userInput);
        Validation.isItRange(userInput);
        return userInput;
    }
}
