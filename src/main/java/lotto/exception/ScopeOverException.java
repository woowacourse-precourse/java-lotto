package lotto.exception;

import lotto.print.Print;

public class ScopeOverException {
    public static Integer scopeCheck(Integer putNumber) {
        if (45 < putNumber || putNumber < 1) {
            Print.sendError(new ScopeOverException());
            throw new IllegalArgumentException();
        }//if
        return putNumber;
    }//ScopeCheck
} // end class
