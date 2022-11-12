package lotto.validator.view;

import lotto.exception.UtilClassCreateException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputNumberValidator {
    private static final String NON_NUMERIC_CHARACTERS_EXCEPTION_MESSAGE = "[ERROR] '숫자'만 입력 가능합니다.";
    private static final String EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE = "[ERROR] 1번째 자리에는 0이 올 수 없습니다.";
    private static final String DIGIT_OUT_OF_RANGE_EXCEPTION = "[ERROR] 숫자의 자릿수는 9자리를 초과할 수 없습니다.";
    private static final String INPUT_NON_NUMBER_FORM = "\\D";
    private static final String EXIST_ZERO_AT_FIRST_PLACE_FORM = "0\\d+";
    private static final String DIGIT_OUT_OF_RANGE_FORM = "\\d{10}";
    
    private InputNumberValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(final String inputPayment) {
        validateNullOrEmpty(inputPayment);
        validateInputNumberFormatMatching(inputPayment);
        validateZeroAtFirstPlaceExist(inputPayment);
        validateDigitRangeOfOut(inputPayment);
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
        return matcher(inputPayment, INPUT_NON_NUMBER_FORM).find();
    }
    
    private static void validateZeroAtFirstPlaceExist(final String inputPayment) {
        if (isExistZeroAtFirstPlace(inputPayment)) {
            throw new IllegalArgumentException(EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isExistZeroAtFirstPlace(final String inputPayment) {
        return matcher(inputPayment, EXIST_ZERO_AT_FIRST_PLACE_FORM).matches();
    }
    
    private static void validateDigitRangeOfOut(final String inputPayment) {
        if (isNumberDigitOutOfRange(inputPayment)) {
            throw new IllegalArgumentException(DIGIT_OUT_OF_RANGE_EXCEPTION);
        }
    }
    
    private static boolean isNumberDigitOutOfRange(final String inputPayment) {
        return matcher(inputPayment, DIGIT_OUT_OF_RANGE_FORM).find();
    }
    
    private static Matcher matcher(final String inputPayment, final String correctInputForm) {
        return compiler(correctInputForm).matcher(inputPayment);
    }
    
    private static Pattern compiler(final String correctInputForm) {
        return Pattern.compile(correctInputForm);
    }
}
