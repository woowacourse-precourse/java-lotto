package lotto.domain.exceptions;

import lotto.data.ErrorMessage;

import java.util.Arrays;

public class WinNumInputException {

    public static void winNumFormatError(String inputWinNums) {
        if (!inputWinNums.contains(","))
            throw new IllegalArgumentException(ErrorMessage.COMMA_ERROR.getErrorLog());
    }

    public static void winNumTypeError(String inputWinNum) {
        for (int i = 0; i < inputWinNum.length(); i++)
            if (!Character.isDigit(inputWinNum.charAt(i)))
                throw new IllegalArgumentException(ErrorMessage.TYPE_ERROR.getErrorLog());
    }

    public static void winNumRangeError(int tmpWinNum) {
        if (tmpWinNum < 0 || tmpWinNum > 45)
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorLog());
    }

    public static void winNumDuplicate(String[] tmpWinNums) {
        if (tmpWinNums.length != Arrays.stream(tmpWinNums).distinct().count())
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getErrorLog());
    }
    public static void winNumSizeError(String[] tmpWinNums){
        if(tmpWinNums.length!=6)
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getErrorLog());
    }
}
