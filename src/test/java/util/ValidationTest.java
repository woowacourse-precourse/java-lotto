package util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 구입 금액이 1000의 배수가 아니면 에러가 발생한다.")
    @Test
    void createPurchaseMoneyNotDivision1000() {
        // given
        String prchaseMoney = "1111";

        // when + then
        assertThatThrownBy(() -> Validation.validatePurchaseMoney(prchaseMoney))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);

    }

    @DisplayName("당첨 번호 입력에 숫자와 , 이외의 값이 들어가면 에러가 발생한다,")
    @Test
    void createWinningNumberByOtherThanNumAndComma() {
        // given
        String winningNumber = "r..absdc";

        // when + then
        assertThatThrownBy(() -> Validation.validateWinningNumberContainCommaAndNum(winningNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호 입력에 ,가 처음과 끝에 들어가면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,4,5,6", "1,2,3,4,5,6,"})
    void createWinningNumberByStartWithOrEndWithComma(String winningNumber) {
        assertThatThrownBy(() -> Validation.validateWinningNumberStartOrEndWithComma(winningNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

}