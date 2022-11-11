package lotto.view.validator;

import lotto.exception.UtilClassCreateException;

public class InputWinningLottoValidator {
    private InputWinningLottoValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(final String inputWinningLottoNumbers) {
        validateNullOrEmpty(inputWinningLottoNumbers);
    }
    
    private static void validateNullOrEmpty(final String inputPayment) {
        InputValidator.validateNullOrEmpty(inputPayment);
    }
}
