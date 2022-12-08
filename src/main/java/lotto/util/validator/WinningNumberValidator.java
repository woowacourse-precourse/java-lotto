package lotto.util.validator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberValidator extends Validator {

    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> winningNumbers = splitByComma(input);
        for (String winningNumber : winningNumbers) {
            validateNumeric(winningNumber);
            validateRange(winningNumber);
            validateLottoNumberRange(winningNumber);
        }
    }

    private static List<String> splitByComma(String input) {
        return new ArrayList<>(List.of(Validator.removeSpace(input).split(",")));
    }

}
