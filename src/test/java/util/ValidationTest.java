package util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}