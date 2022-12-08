package lotto.util.validator;

public class BonusNumberValidator extends Validator {

    @Override
    public void validate(String input) throws IllegalArgumentException {
        String bonusNumber = removeSpace(input);
        validateNumeric(bonusNumber);
        validateRange(bonusNumber);
    }



}
