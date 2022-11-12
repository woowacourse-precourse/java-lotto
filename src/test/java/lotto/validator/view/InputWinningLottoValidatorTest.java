package lotto.validator.view;

import lotto.constants.ErrorMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputWinningLottoValidatorTest {
    @DisplayName("올바른 당첨 번호 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,10,20,30,40,45", "45,40,30,20,10,1", "45,30,10,20,40,1"})
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
    
    @DisplayName("예외 처리 : 쉼표 개수가 5개가 아닌 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3,4,5,,", ",,1,2,3,4,5"})
    void countOfCommaException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 가장자리에 쉼표가 있는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3,4,5,45,", ",1,2,3,4,5,6"})
    void commaAtEdgeExistException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 숫자 5개, 쉼표 5개인 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3,4,45,", ",1,2,3,4,6", "1,2,3,,4,6"})
    void countOfNumberException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 숫자의 사이에 쉼표가 여러개 붙어있는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,,2,3,4,5,45", "1,2,3,,,4,5,6", "1,2,3,4,5,,6"})
    void duplicateCommaException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 가장자리에 숫자가 비어있는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {",2,3,4,5,45", "1,2,3,4,45,", " ,2,3,4,5,6", "1,2,3,4,5, "})
    void numberAtEdgeEmptyException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 1번째 자리에 0이 들어오는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"01,2,3,4,5,45", "1,2,3,4,5,045", "1,002,3,4,5,6", "1,2,3,4,005,45", "1,2,3,4,5,0045"})
    void zeroAtTensPlaceExistException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 쉽표 5개만 입력하는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {",,,,,", " ,,,,,", ",,,,, ", ",,,, ,", ", ,,,,"})
    void onlyFiveCommaInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputWinningLottoValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}