package lotto.validator.view;

import lotto.exception.UtilClassCreateException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputWinningLottoValidator {
    private static final String WINNING_LOTTO_INPUT_FORM_EXCEPTION_MESSAGE = "[ERROR] 로또 번호 입력 형식이 잘못 되었습니다.";
    private static final String EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE = "[ERROR] 숫자의 1번째 자리는 0일 수 없습니다.";
    private static final String WINNING_LOTTO_INPUT_FORM = "(\\d+,){5}\\d+";
    private static final String EXIST_ZERO_AT_FIRST_PLACE_FORM = "0\\d+";
    
    private InputWinningLottoValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(final String inputWinningLottoNumbers) {
        validateNullOrEmpty(inputWinningLottoNumbers);
        validateInputWinningLottoFormatMatching(inputWinningLottoNumbers);
        validateZeroAtFirstPlaceExist(inputWinningLottoNumbers);
    }
    
    private static void validateNullOrEmpty(final String inputPayment) {
        InputValidator.validateNullOrEmpty(inputPayment);
    }
    
    private static void validateInputWinningLottoFormatMatching(final String inputWinningLottoNumbers) {
        if (isNotMatchInputFormat(matcher(inputWinningLottoNumbers, WINNING_LOTTO_INPUT_FORM))) {
            throw new IllegalArgumentException(WINNING_LOTTO_INPUT_FORM_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isNotMatchInputFormat(final Matcher matcher) {
        return !matcher.matches();
    }
    
    private static void validateZeroAtFirstPlaceExist(final String inputWinningLottoNumbers) {
        if (isExistZeroAtFirstPlace(inputWinningLottoNumbers)) {
            throw new IllegalArgumentException(EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isExistZeroAtFirstPlace(final String inputPayment) {
        return matcher(inputPayment, EXIST_ZERO_AT_FIRST_PLACE_FORM).find();
    }
    
    private static Matcher matcher(final String inputWinningLottoNumbers, final String correctLottoNumbersForm) {
        return compiler(correctLottoNumbersForm).matcher(inputWinningLottoNumbers);
    }
    
    private static Pattern compiler(final String correctInputForm) {
        return Pattern.compile(correctInputForm);
    }
}
