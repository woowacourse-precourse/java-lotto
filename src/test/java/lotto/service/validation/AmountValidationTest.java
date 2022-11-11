package lotto.service.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountValidationTest {
    @DisplayName("금액이 음수 값일 경우 false 반환")
    @Test
    void amount_is_minus_Test() {
        int amount = -100;
        boolean EXPECTED_RESULT = false;
        boolean result = AmountValidation.isValidAmount(amount);
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("금액이 1000원 이하일 경우 false 반환")
    @Test
    void amount_is_lower_than_unit_of_amount_Test() {
        int amount = -100;
        boolean EXPECTED_RESULT = false;
        boolean result = AmountValidation.isValidAmount(amount);
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("금액이 1000원 단위가 아닌 경우 false 반환")
    @Test
    void amount_does_not_match_the_unit() {
        int amount = 1001;
        boolean EXPECTED_RESULT = false;
        boolean result = AmountValidation.isValidAmount(amount);
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("금액이 1000원 단위인 올바른 값인 경우 true 반환")
    @Test
    void amount_conditions_are_satisfied() {
        int amount = 2345000;
        boolean EXPECTED_RESULT = true;
        boolean result = AmountValidation.isValidAmount(amount);
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }
}
