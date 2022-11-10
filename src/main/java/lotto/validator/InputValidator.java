package lotto.validator;

public class InputValidator extends CommonValidator {

    public static boolean restEqualZero(long dividend, long divisor) {
        return dividend % divisor == 0;
    }

    public static boolean isZero(long number) {
        return number == 0;
    }
}