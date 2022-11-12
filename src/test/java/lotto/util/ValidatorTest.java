package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @DisplayName("구매금액이 금액단위를 따르는지 여부 반환 - 따르지 않음")
    @Test
    void validateUnitStandardNotFollow() {
        // given
        int purchaseAmount = 8_001;

        // expected
        assertThatThrownBy(() -> Validator.validateUnitStandard(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 금액단위를 따르는지 여부 반환 - 따름")
    @Test
    void validateUnitStandardFollow() {
        // given
        int purchaseAmount = 8_000;

        // expected
        Validator.validateUnitStandard(purchaseAmount);
    }
}