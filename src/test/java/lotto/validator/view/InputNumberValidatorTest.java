package lotto.validator.view;

import lotto.constants.ErrorMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputNumberValidatorTest {
    @DisplayName("숫자만 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"14000", "1", "45"})
    void correctPaymentInputForm(String input) {
        assertThatNoException()
                .isThrownBy(() -> InputNumberValidator.validate(input));
    }
    
    @DisplayName("예외 처리 : null or empty 를 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @NullAndEmptySource
    void nullOrEmptyInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 한글 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"14ㄱ000", "ㅏ14000", "14가000"})
    void koreanInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 영어 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"a14000", "14A000"})
    void englishInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 특수 문자 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"14%000", "14$000"})
    void specialCharactersInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 공백 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"14 000", " 14000", "14000 "})
    void spaceInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 첫번째 자리에 0이 오는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"014000", "0014000", "00014000", "01", "001", "045", "0045", "00045"})
    void zeroAtFirstPlaceExistException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 9자리를 넘기는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1400000000", "1234567890", "12345678901234567890"})
    void digitOutOfRangeException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}