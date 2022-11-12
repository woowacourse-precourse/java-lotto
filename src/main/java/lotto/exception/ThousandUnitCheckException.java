package lotto.exception;

import lotto.print.Print;

public class ThousandUnitCheckException {
    public static Integer unitCheck(Integer money) {
        if (money % 1000 != 0) {
            Print.sendError(new ThousandUnitCheckException());
            throw new IllegalArgumentException();
        }//if
        return money;
    }// UnitVerify
} // end class
