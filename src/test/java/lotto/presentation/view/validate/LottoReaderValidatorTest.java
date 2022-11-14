package lotto.presentation.view.validate;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoReaderValidatorTest {

    @DisplayName("입력된 값이 숫자이면 통과")
    @Test
    void createNumberLottoAmount() {
        String lottoAmount = "1000";
        Assertions.assertThatCode(() -> LottoReaderValidator.validateNumber(lottoAmount))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력된 값이 숫자가 아닌 다른 문자이면 예외 발생")
    @Test
    void createAnotherCharacterLottoAmount() {
        String lottoAmount = "1000a";
        Assertions.assertThatThrownBy(() -> LottoReaderValidator.validateNumber(lottoAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("','를 구분자로 하고, 모두 숫자로 이루어지면 성공")
    @Test
    void validateGoodWinNumber () {
        String winNumber = "1,2,3,4,5,6";
        Assertions.assertThatCode(() -> LottoReaderValidator.validateCommaSeparatorArray(winNumber))
                .doesNotThrowAnyException();
    }


    @DisplayName("','를 구분자로 하고, 모두 숫자로 이루어지지 않으면 예외 발생")
    @Test
    void validateBadWinNumber () {
        String winNumber = "1/2/3/4/5/a";
        Assertions.assertThatThrownBy(() -> LottoReaderValidator.validateCommaSeparatorArray(winNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }




}