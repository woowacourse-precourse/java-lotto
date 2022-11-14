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
            Validation.isItSix(numbers);
            Validation.isItRange(numbers);
        }catch (IllegalArgumentException err){
            System.out.println(err);
        }
        return userInput;
    }
}
