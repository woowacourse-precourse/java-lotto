package lotto;

import java.util.Arrays;

public class WinNumInputException {

    public static void winNumFormatError(String input) {
        if (!input.contains(","))
            throw new IllegalArgumentException(ErrorMessage.COMMA_ERROR.getErrorLog());
    }

    public static void winNumTypeError(String input) {
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException(ErrorMessage.TYPE_ERROR.getErrorLog());
    }

    public static void winNumRangeError(int number) {
        if (number < 0 || number > 45)
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorLog());
    }

    public static void winNumDuplicate(String[] input) {
        if (input.length != Arrays.stream(input).distinct().count())
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getErrorLog());
    }
    public static void winNumSizeError(String[] input){
        if(input.length!=6)
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getErrorLog());
    }
}
