package lotto.exception;


import lotto.print.Print;

public class NumberVerification {
    public static Integer verify(String value) {
        if (!(isNumeric(value))) {
            Print.sendError(new NumberVerification());
            throw new IllegalArgumentException();
        }//if
        return Integer.parseInt(value);
    } // verify

    static boolean isNumeric(String value) {
        return value.chars().allMatch(Character::isDigit);
    }//isNumeric
}// end class
