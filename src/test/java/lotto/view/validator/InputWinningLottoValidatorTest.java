package lotto.view.validator;

import lotto.domain.validator.ErrorMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputWinningLottoValidatorTest {
    @DisplayName("올바른 당첨 로또 번호 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,10,20,30,40,45"})
    void correctPaymentInput(String input) {
        assertThatNoException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input));
    }
    
    @DisplayName("예외 처리 : null or empty 를 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @NullAndEmptySource
    void nullOrEmptyInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 한글 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3,ㄱ,5,6", "1,2,3,ㅏ,5,6", "1,2,3,4,5,가"})
    void koreanInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 영어 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3,a,5,6", "1,2,3,A,5,6"})
    void englishInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 특수 문자 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3,%,5,6", "1,2,3,$,5,6"})
    void specialCharactersInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 공백 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3, ,5,6", "1,2,3,4,5,6 ", " 1,2,3,4,5,6", "1,2,3,4,5, "})
    void spaceCharactersInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 구분 기호가 쉼표가 아닌 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3.4,5,6", "1,2,3 4,5,6", "1,10,20:30,40,45"})
    void delimiterException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}