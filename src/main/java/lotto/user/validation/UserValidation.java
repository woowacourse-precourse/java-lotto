package lotto.user.validation;


public class UserValidation {
    private static final int AMOUNT_UNITS = 1000;
    private static final int REMAINDER_ZERO = 0;

    public static void validate(String userAmount) {
        validateUnits(userAmount);
    }

    private static void validateUnits(String userAmount) {
        if ((Integer.parseInt(userAmount) % AMOUNT_UNITS) != REMAINDER_ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.UNITS.toString());
        }
    }
}
