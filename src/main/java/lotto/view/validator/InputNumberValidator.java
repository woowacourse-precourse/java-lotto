package lotto.view.validator;

import lotto.exception.UtilClassCreateException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputNumberValidator {
    private static final String NON_NUMERIC_CHARACTERS_EXCEPTION_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String INPUT_NON_NUMBER_FORM = "\\D";
    
    private InputNumberValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(final String inputPayment) {
        validateNullOrEmpty(inputPayment);
        validateInputNumberFormatMatching(inputPayment);
    }
    
    private static void validateNullOrEmpty(final String inputPayment) {
        InputValidator.validateNullOrEmpty(inputPayment);
    }
    
    private static void validateInputNumberFormatMatching(final String inputPayment) {
        if (isNonNumericCharactersExist(inputPayment)) {
            throw new IllegalArgumentException(NON_NUMERIC_CHARACTERS_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isNonNumericCharactersExist(final String inputPayment) {
        final Matcher matcher = Pattern.compile(INPUT_NON_NUMBER_FORM).matcher(inputPayment);
        return matcher.find();
    }
}
