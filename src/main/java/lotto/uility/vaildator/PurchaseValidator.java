package lotto.uility.vaildator;

import java.rmi.server.ExportException;
import java.util.regex.Pattern;

public class PurchaseValidator {

    protected void validateInput(String lottoPrice) {
        if (validateNumberFormat(lottoPrice)) {
            throw new IllegalArgumentException(ValidateConstants.ERROR + ValidateConstants.INPUT_NUMBER_VALIDATE);
        } else if (ConvertStringToInteger(lottoPrice) % ValidateConstants.LOTTO_PRICE > 0) {
            throw new IllegalArgumentException(ValidateConstants.ERROR + ValidateConstants.ONE_THOUSAND_VALIDATE);
        } else if (!validateInputIsDigit(lottoPrice)) {
            throw new IllegalArgumentException(ValidateConstants.ERROR + ValidateConstants.INPUT_IS_CORRECT);
        }
    }

    private boolean validateInputIsDigit(String lottoPrice) {
        return lottoPrice.chars().allMatch(Character::isDigit);
    }

    private boolean validateNumberFormat(String lottoPrice) {
        String regExp = "^[1-9]\\d*0{3}$";
        if (Pattern.matches(regExp, lottoPrice)) {
            return false;
        }
        return true;
    }

    public int ConvertStringToInteger(String input) {
        return Integer.parseInt(input);
    }
}
