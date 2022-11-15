package lotto.exception;

import lotto.print.Print;

public class InputSixDigitException {
    public static String[] OverCheck(String putWinningNumber) {
        String[] WinningNumber = putWinningNumber.split(",");

        if (6 != WinningNumber.length) {
            Print.sendError(new InputSixDigitException());
            throw new IllegalArgumentException();
        }//if
        return WinningNumber;
    }//OverCheck
}// end class
