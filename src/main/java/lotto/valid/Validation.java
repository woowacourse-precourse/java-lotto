package lotto.valid;

import lotto.Util.OutputPrint;
import lotto.type.ErrorType;
import lotto.type.NumberBoundaryType;

import java.util.List;

public class Validation {

    public static void purchaseNumberValid(String number){
        if (!number.matches("-?\\d+(\\.\\d+)?")){
            throw new IllegalArgumentException();
        }
        int numberConversion = Integer.parseInt(number);
        if (numberConversion % 1000 != 0 || numberConversion == 0) {
            throw new IllegalArgumentException(ErrorType.INVALID_PRICE_INPUT.getText());
        }
    }

    public static void isGeneratedNumberValid(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_DIGITS.getText());
        }
        isDuplicated(numbers);
    }

    public static void prizeNumbersValid(List<Integer> prizeNumbers){
        if (prizeNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_DIGITS.getText());
        }
        isDuplicated(prizeNumbers);
        for (int splitNum : prizeNumbers) {
            if (splitNum < NumberBoundaryType.MINIMUM_INDEX.getBoundary()
                    || splitNum > NumberBoundaryType.MAXIMUM_INDEX.getBoundary()) {
                throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_RANGE.getText());
            }
        }
    }

    private static void isDuplicated(List<Integer> prizeNumbers) {
        if(prizeNumbers.size() != prizeNumbers.stream().distinct().count()){
            throw new IllegalArgumentException(ErrorType.INVALID_DUPLICATED_NUMBER.getText());
        }
    }

    public static void bonusNumberValid(String bonus) {
        if (!bonus.matches("-?\\d+(\\.\\d+)?")){
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT_TYPE.getText());
        }

        if (Integer.parseInt(bonus) < NumberBoundaryType.MINIMUM_INDEX.getBoundary()
                || Integer.parseInt(bonus) > NumberBoundaryType.MAXIMUM_INDEX.getBoundary()) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_RANGE.getText());
        }
    }
}
