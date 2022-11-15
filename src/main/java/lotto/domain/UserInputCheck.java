package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validation;

public class UserInputCheck {
    static Integer purchaseAmountCheck(String userInput) {
        try {
            Validation.isNumber(userInput);
            Validation.isHigherThanMinPrice(userInput);
            Validation.isItDivided(userInput);
        } catch (IllegalArgumentException err) {
            System.out.println(err);
            return 0;
        }
        return Integer.parseInt(userInput);
    }

    static List<Integer> winningNumberCheck(String userInput) {
        String[] numbers = userInput.split(",");
        try {
            Validation.isNumber(numbers);
            Validation.isValidLength(numbers);
            Validation.isItRange(numbers);
        } catch (IllegalArgumentException err) {
            System.out.println(err);
            return Collections.emptyList();
        }
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    static int bonusNumberCheck(String userInput) {
        try {
            Validation.isNumber(userInput);
            Validation.isValidLength(userInput);
            Validation.isItRange(userInput);
        } catch (IllegalArgumentException err) {
            System.out.println(err);
            return 0;
        }
        return Integer.parseInt(userInput);
    }
}
