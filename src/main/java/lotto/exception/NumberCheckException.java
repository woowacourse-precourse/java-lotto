package lotto.exception;


import lotto.print.Print;

public class NumberCheckException {
    public static Integer check(String value) {
        if (!(isNumeric(value))) {
            Print.sendError(new NumberCheckException());
            throw new IllegalArgumentException();
        }//if
        return Integer.parseInt(value);
    } // verify

    static boolean isNumeric(String value) {
        return value.chars().allMatch(Character::isDigit);
    }//isNumeric
}// end class
