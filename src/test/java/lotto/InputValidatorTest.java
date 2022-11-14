package lotto;

import lotto.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @DisplayName("로또 번호 6자리만 허용")
    @Test
    void validateLottoLength() {
        assertThatThrownBy(()->InputValidator.validateLotto(List.of(1,2,3,4,5,6,7))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->InputValidator.validateLotto(List.of(1,2,3,4,5))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 발생")
    @Test
    void validateLottoDuplicate(){
        assertThatThrownBy(()->InputValidator.validateDuplicatedNumber(List.of(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 1~45가 아니면 예외 발생")
    @Test
    void validateLottoNumberRangeTest(){
        assertThatThrownBy(()->InputValidator.validateLottoNumberRange(47)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->InputValidator.validateLottoNumberRange(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 정수가 아닌 문자가 있으면 예외 발생")
    @Test
    void validateInputFormatTest() {
        assertThatThrownBy(()->InputValidator.validateInputFormat("1000l")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 0보다 작거나 1000의 배수가 아니면 오류 발생")
    @Test
    void validatePurchaseAmountTest(){
        assertThatThrownBy(()->InputValidator.validatePurchaseAmount(-1000)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->InputValidator.validatePurchaseAmount(3300)).isInstanceOf(IllegalArgumentException.class);
    }
}