package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ValidationUtilTest {

    @Test
    @DisplayName("로또 구입 금액 입력값 정적성 검토")

    void validatePurchaseAmountInput() {
        int purchaseAmount = -1004;

        boolean isPositiveNum = ValidationUtil.validatePositiveNum(purchaseAmount);
        boolean isRemainder = ValidationUtil.validateRemainder(purchaseAmount);

        assertThat(isPositiveNum).isFalse();
        assertThat(isRemainder).isFalse();
    }

}