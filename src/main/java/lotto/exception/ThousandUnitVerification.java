package lotto.exception;

import lotto.print.Print;

public class ThousandUnitVerification {
    public static Integer unitVerify(Integer money) {
        if (money % 1000 != 0) {
            Print.sendError(new ThousandUnitVerification());
            throw new IllegalArgumentException();
        }//if
        return money;
    }// UnitVerify
} // end class
