package lotto.validator.view;

import lotto.exception.UtilClassCreateException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputWinningLottoValidator {
    private static final String WINNING_LOTTO_INPUT_FORM_EXCEPTION_MESSAGE = "[ERROR] 로또 번호 입력 형식이 잘못 되었습니다.";
    private static final String EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE = "[ERROR] 숫자의 1번째 자리는 0일 수 없습니다.";
    private static final String DIGIT_OUT_OF_RANGE_EXCEPTION = "[ERROR] 숫자의 자릿수는 9자리를 초과할 수 없습니다.";
    private static final String WINNING_LOTTO_INPUT_FORM = "(\\d+,){5}\\d+";
    private static final String EXIST_ZERO_AT_FIRST_PLACE_FORM = "0\\d+";
    private static final String DIGIT_OUT_OF_RANGE_FORM = "\\d{10}";
    private static final String COMMA_DELIMITER = ",";
    
    private InputWinningLottoValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(final String inputWinningLottoNumbers) {
        validateNullOrEmpty(inputWinningLottoNumbers);
        validateInputWinningLottoFormatMatching(inputWinningLottoNumbers);
        validateZeroAtFirstPlaceExist(inputWinningLottoNumbers);
        validateDigitRangeOfOut(inputWinningLottoNumbers);
    }
    
    private static void validateNullOrEmpty(final String inputWinningLottoNumbers) {
        InputValidator.validateNullOrEmpty(inputWinningLottoNumbers);
    }
    
    private static void validateInputWinningLottoFormatMatching(final String inputWinningLottoNumbers) {
        if (isNotMatchInputFormat(inputWinningLottoNumbers)) {
            throw new IllegalArgumentException(WINNING_LOTTO_INPUT_FORM_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isNotMatchInputFormat(final String inputWinningLottoNumbers) {
        return !matcher(inputWinningLottoNumbers, WINNING_LOTTO_INPUT_FORM).matches();
    }
    
    private static void validateZeroAtFirstPlaceExist(final String inputWinningLottoNumbers) {
        if (isNumberExistZeroAtFirstPlace(inputWinningLottoNumbers)) {
            throw new IllegalArgumentException(EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isNumberExistZeroAtFirstPlace(final String inputWinningLottoNumbers) {
        return Arrays.stream(inputWinningLottoNumbers.split(COMMA_DELIMITER))
                .anyMatch(InputWinningLottoValidator::isExistZeroAtFirstPlace);
    }
    
    private static boolean isExistZeroAtFirstPlace(final String inputWinningLottoNumber) {
        return matcher(inputWinningLottoNumber, EXIST_ZERO_AT_FIRST_PLACE_FORM).matches();
    }
    
    private static void validateDigitRangeOfOut(final String inputWinningLottoNumbers) {
        if (isNumberDigitOutOfRangeExist(inputWinningLottoNumbers)) {
            throw new IllegalArgumentException(DIGIT_OUT_OF_RANGE_EXCEPTION);
        }
    }
    
    private static boolean isNumberDigitOutOfRangeExist(final String inputWinningLottoNumbers) {
        return Arrays.stream(inputWinningLottoNumbers.split(COMMA_DELIMITER))
                .anyMatch(InputWinningLottoValidator::isExistDigitRangeOfOut);
    }
    
    private static boolean isExistDigitRangeOfOut(final String inputWinningLottoNumber) {
        return matcher(inputWinningLottoNumber, DIGIT_OUT_OF_RANGE_FORM).find();
    }
    
    private static Matcher matcher(final String inputWinningLottoNumbers, final String correctLottoNumbersForm) {
        return compiler(correctLottoNumbersForm).matcher(inputWinningLottoNumbers);
    }
    
    private static Pattern compiler(final String correctInputForm) {
        return Pattern.compile(correctInputForm);
    }
}
