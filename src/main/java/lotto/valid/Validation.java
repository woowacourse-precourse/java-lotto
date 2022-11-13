package lotto.valid;

import lotto.type.ErrorType;
import lotto.type.NumberBoundaryType;

import java.util.List;

public class Validation {

    public static void purchaseNumberValid(int number){
        if (number % 1000 != 0 || number == 0) {
            throw new IllegalArgumentException(ErrorType.INVALID_PRICE_INPUT.getText());
        }
    }

    public static void isGeneratedNumberValid(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_DIGITS.getText());
        }
    }

    public static void prizeNumbersValid(List<Integer> prizeNumbers){
        if (prizeNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_DIGITS.getText());
        }

        for (int splitNum : prizeNumbers) {
            if (splitNum < NumberBoundaryType.MINIMUM_INDEX.getBoundary()
                    || splitNum > NumberBoundaryType.MAXIMUM_INDEX.getBoundary()) {
                throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_RANGE.getText());
            }
        }
    }

    public static void bonusNumberValid(String bonus) {
        if (Integer.parseInt(bonus) < NumberBoundaryType.MINIMUM_INDEX.getBoundary()
                || Integer.parseInt(bonus) > NumberBoundaryType.MAXIMUM_INDEX.getBoundary()) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_RANGE.getText());
        }

        if (bonus.equals("[^a-zA-Z]")){
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT_TYPE.getText());
        }

    }
}
