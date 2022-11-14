package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    static List<Integer> winningNumberCheck(String userInput) {
        String[] numbers = userInput.split(",");
        try {
            Validation.isNumber(numbers);
            Validation.isValidLength(numbers);
            Validation.isItRange(numbers);
        }catch (IllegalArgumentException err){
            System.out.println(err);
        }
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    static int bonusNumberCheck(String userInput){
        Validation.isNumber(userInput);
        Validation.isValidLength(userInput);
        Validation.isItRange(userInput);
        return Integer.parseInt(userInput);
    }
}
