package lotto;

import lotto.exception.UserExceptionController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserExceptionControllerTest {

    @DisplayName("입력 금액이 1000의 배수가 아니면 예외 발생")
    @Test
    void validatePriceTest() {
        String price = "1500";
        assertThatThrownBy(() -> UserExceptionController.validatePrice(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호 4개만 주어진다면 예외 발생")
    @Test
    void validateWinningNumbersTest() {
        assertThatThrownBy(() -> UserExceptionController
                .validateWinningNumbers("1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호가 잘못됐다면 예외 발생")
    @Test
    void validateWinningNumbersTest2() {
        assertThatThrownBy(() -> UserExceptionController
                .validateWinningNumbers("1,2,3,49,5,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> UserExceptionController
                .validateWinningNumbers("1,2,3,4k,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45의 값이 아니면 예외 발생")
    @Test
    void validateNumberTest() {
        String invalidNumber = "50";
        assertThatThrownBy(() -> UserExceptionController.validateLottoNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 숫자가 아니라면 예외 발생")
    @Test
    void validateLottoNumberTest() {
        String invalidNumber = "5k";
        assertThatThrownBy(() -> UserExceptionController.validatePrice(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}