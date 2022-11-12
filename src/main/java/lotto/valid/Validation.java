package lotto.valid;

import lotto.type.ErrorType;
import lotto.type.NumberBoundaryType;

import java.util.List;

public class Validation {

    public static void purchaseNumberValid(int number){
        if (number % 1000 != 0 || number == 0) {
            throw new IllegalArgumentException(String.valueOf(ErrorType.INVALID_PRICE_INPUT));
        }
    }

    public static void isGeneratedNumberValid(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(String.valueOf(ErrorType.INVALID_NUMBER_DIGITS));
        }
    }

    public static void prizeNumbersValid(List<Integer> prizeNumbers){
        if (prizeNumbers.size() != 6) {
            throw new IllegalArgumentException(String.valueOf(ErrorType.INVALID_NUMBER_DIGITS));
        }

        for (int splitNum : prizeNumbers) {
            if (splitNum < NumberBoundaryType.MINIMUM_INDEX.getBoundary()
                    || splitNum > NumberBoundaryType.MAXIMUM_INDEX.getBoundary()) {
                throw new IllegalArgumentException(String.valueOf(ErrorType.INVALID_NUMBER_RANGE));
            }
        }
    }
}
