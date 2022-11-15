package lotto.domain;

import java.util.NoSuchElementException;

import static lotto.view.ErrorMessage.*;

public class AdditionalFunction {
    public static int StringToInt(String inputNumber){
        try{
            int outputNumber = Integer.parseInt(inputNumber);
            return outputNumber;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_MESSAGE+NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void validateNumRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE+RANGE_ERROR_MESSAGE);
        }
    }
}
