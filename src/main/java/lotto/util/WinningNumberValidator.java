package lotto.util;

public class WinningNumberValidator extends Validator {

    @Override
    public void validate(String input) throws IllegalArgumentException {
        String winningNumber = Validator.removeSpace(input);
    }

}
