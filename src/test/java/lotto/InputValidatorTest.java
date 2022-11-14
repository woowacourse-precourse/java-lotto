package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();
    @Test
    @DisplayName("구매 비용입력시 숫자가 아닐 때")
    void purchaseNotNumber() throws Exception {
        //given
        String input = "1000kk";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매비용 입력시 천 단위가 아니면 예외처리")
    void purchaseNotThousand() throws Exception {
        //given
        String input = "100080";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}