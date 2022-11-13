package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    @DisplayName("구매금액이 숫자이며, 지정한 단위로 입력되었는 지 검증하는 기능 테스트")
    void amount_unit_validation_test() {
        String validAmount = "13000";
        String invalidAmount = "-13000";
        String invalidUnit = "13500";
        int unit = 1000;

        assertThat(Validator.amountUnitIsValid(validAmount, unit))
                .isTrue();
        assertThatThrownBy(() -> Validator.amountUnitIsValid(invalidAmount, unit))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.amountUnitIsValid(invalidUnit, unit))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
