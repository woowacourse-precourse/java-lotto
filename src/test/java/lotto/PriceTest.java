package lotto;

import lotto.model.Price;
import lotto.model.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceTest {
    @DisplayName("금액 입력이 숫자가 아니면 예외 발생")
    @Test
    void createPriceByInvalid() {
        assertThatThrownBy(() -> new Price("400a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DIGIT_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("금액이 1000원보다 작으면 예외 발생")
    @Test
    void createPriceByUnder() {
        assertThatThrownBy(() -> new Price("800"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PRICE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("금액이 1000원 단위가 아니면 예외 발생")
    @Test
    void createPriceByNotDivide() {
        assertThatThrownBy(() -> new Price("5600"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PRICE_ERROR_MESSAGE.getMessage());
    }
}