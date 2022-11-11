package lotto.validator.view;

import lotto.exception.UtilClassCreateException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputWinningLottoValidator {
    private static final String WINNING_LOTTO_INPUT_FORM = "[^\\d,]";
    public static final String WINNING_LOTTO_INPUT_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 숫자와 쉼표 외엔 입력할 수 없습니다.";
    
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
        return matcher.find();
    }
}
