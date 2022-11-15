package lotto.ui;

import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class InputTest {

    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void validatePurchaseAmount() {
        int isDivisible = 2000;
        int isNotDivisible = 2001;

        assertAll(
                () -> assertThat(Input.validatePurchaseAmount(isDivisible)).isEqualTo(isDivisible),
                () -> assertThatThrownBy(() -> Input.validatePurchaseAmount(isNotDivisible))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.PURCHASE_AMOUNT_ERROR)
        );
    }

    @DisplayName("당첨 번호의 유효성을 검증하여 예외처리 한다.")
    @Test
    void validateWiningNumber() {
        String overSizeNumber = "1,2,3,4,5,6,7";
        String strangeNumber = "1.2.3.4.5.6";
        String outOfRangeNumber = "1,2,3,4,5,46";
        String duplicatedNumber = "1,2,3,4,6,6";

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateWiningNumber(strangeNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.WINING_NUMBER_SPLIT_LENGTH_ERROR),
                () -> assertThatThrownBy(() -> Input.validateWiningNumber(overSizeNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.WINING_NUMBER_SPLIT_LENGTH_ERROR),
                () -> assertThatThrownBy(() -> Input.validateWiningNumber(outOfRangeNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR),
                () -> assertThatThrownBy(() -> Input.validateWiningNumber(duplicatedNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_DUPLICATED_ERROR));
    }

    @DisplayName("보너스 번호의 유효성을 검증하여 예외처리 한다.")
    @Test
    void validateBonusNumber() {
        String severalNumber = "1 2";
        String outOfRangeNumber = "50";

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateBonusNumber(severalNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.BONUS_NUMBER_LENGTH_ERROR),
                () -> assertThatThrownBy(() -> Input.validateBonusNumber(outOfRangeNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR));
    }
}