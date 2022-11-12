package lotto.validator.view;

import lotto.exception.UtilClassCreateException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputWinningLottoValidator {
    private static final String WINNING_LOTTO_INPUT_FORM = "((4[0-5]|[1-3]\\d|[1-9]),){5}(4[0-5]|[1-3]\\d|[1-9])";
    private static final String WINNING_LOTTO_INPUT_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 로또 당첨번호 입력 형식이 잘못 되었습니다.";
    
    private InputWinningLottoValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(final String inputWinningLottoNumbers) {
        validateNullOrEmpty(inputWinningLottoNumbers);
        validateInputWinningLottoFormatMatching(inputWinningLottoNumbers);
    }
    
    private static void validateNullOrEmpty(final String inputPayment) {
        InputValidator.validateNullOrEmpty(inputPayment);
    }
    
    private static void validateInputWinningLottoFormatMatching(final String inputWinningLottoNumbers) {
        if (isNotMatchInputFormat(matcher(inputWinningLottoNumbers))) {
            throw new IllegalArgumentException(WINNING_LOTTO_INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
    
    private static Matcher matcher(final String inputWinningLottoNumbers) {
        return compiler().matcher(inputWinningLottoNumbers);
    }
    
    private static Pattern compiler() {
        return Pattern.compile(WINNING_LOTTO_INPUT_FORM);
    }
    
    private static boolean isNotMatchInputFormat(final Matcher matcher) {
        return !matcher.matches();
    }
}
