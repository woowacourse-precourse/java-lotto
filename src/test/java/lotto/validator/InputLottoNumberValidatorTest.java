package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputLottoNumberValidatorTest {

    @DisplayName("당첨 번호 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,","1,2,3,3,6,7"})
    void inputLottoNumber(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> InputLottoNumberValidator.validate(input));
    }
}