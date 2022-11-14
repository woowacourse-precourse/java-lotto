package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputUtilsTest {

    private static final int PURCHASE_AMOUNT = 8_400;

    @DisplayName("구입 금액이 1,000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByNotDivided1_000() {
            assertThatThrownBy(() -> InputUtils.validatePurchaseAmount(PURCHASE_AMOUNT))
                    .isInstanceOf(IllegalArgumentException.class);
    }

}