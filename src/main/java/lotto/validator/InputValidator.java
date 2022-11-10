package lotto.validator;

public class InputValidator {

    public boolean restEqualZero(long dividend, long divisor) {
        return dividend % divisor == 0;
    }
}
