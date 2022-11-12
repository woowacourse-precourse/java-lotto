package lotto.exception;

import lotto.print.Print;

import java.util.List;

public class InputOverException {
    public static String[] OverCheck(String putWinningNumber) {
        String[] WinningNumber = putWinningNumber.split(",");

        if (6 < WinningNumber.length) {
            Print.sendError(new InputOverException());
            throw new IllegalArgumentException();
        }//if
        return WinningNumber;
    }//OverCheck
}// end class
