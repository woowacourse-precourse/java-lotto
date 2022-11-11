package lotto.valid;

import lotto.type.ErrorType;

import java.util.List;

public class Validation {

    public static void purchaseNumberValid(int number){
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(String.valueOf(ErrorType.INVALID_PRICE_INPUT));
        }
    }

    public static void isGeneratedNumberValid(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(String.valueOf(ErrorType.INVALID_NUMBER_DIGITS));
        }
    }
}
