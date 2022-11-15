package lotto.exception;

import lotto.print.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OverlapsNumberException {
    public static List<String> overlapsCheck(String[] putWinningNumber) {
        List<String> winningNumber = new ArrayList<String>(Arrays.asList(putWinningNumber));
        Collections.sort(winningNumber);
        for (String number : winningNumber) {
            if (1 < Collections.frequency(winningNumber, number)) {
                Print.sendError(new OverlapsNumberException());
                throw new IllegalArgumentException();
            }// if
        }//for
        return winningNumber;
    }// overlapsCheck

    public static String bonusOverlapsCheck(List<String> winningNumber, String bonusNumber) {
        if (0 < Collections.frequency(winningNumber, bonusNumber)) {
            Print.sendError(new OverlapsNumberException());
            throw new IllegalArgumentException();
        }// if
        return bonusNumber;
    }// bonusOverlapsCheck
}// end class
