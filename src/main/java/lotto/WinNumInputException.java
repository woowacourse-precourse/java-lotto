package lotto;

import java.util.Arrays;

public class WinNumInputException {
    public static ErrorMessage errorMessage;

    public static void winNumFormatError(String input) {
        if (!input.contains(","))
            throw new IllegalArgumentException(errorMessage.COMMA_ERROR.getErrorLog());
    }

    public static void winNumTypeError(String input) {
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException(errorMessage.TYPE_ERROR.getErrorLog());
    }

    public static void winNumRangeError(int number) {
        if (number < 0 || number > 45)
            throw new IllegalArgumentException(errorMessage.RANGE_ERROR.getErrorLog());
    }

    public static void winNumDuplicate(String[] input) {
        if (input.length != Arrays.stream(input).distinct().count())
            throw new IllegalArgumentException(errorMessage.DUPLICATE_ERROR.getErrorLog());
    }
    public static void winNumSizeError(String[] input){
        if(input.length!=6)
            throw new IllegalArgumentException(errorMessage.SIZE_ERROR.getErrorLog());
    }
}
