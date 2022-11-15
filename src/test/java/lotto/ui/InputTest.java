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
}