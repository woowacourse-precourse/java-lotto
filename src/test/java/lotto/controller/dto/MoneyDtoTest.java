package lotto.controller.dto;

import lotto.controller.validator.MoneyValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class MoneyDtoTest {

    @DisplayName("로또 구입 금액이 조건에 맞지 않으면 예외가 발생한다.")
    @Test
    void inputInvalidMoney() {
        assertAll(
                () -> assertThatThrownBy(() -> new MoneyDto("non digit"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(MoneyValidator.IS_NATURAL_NUMBER.getErrorMessage()),

                () -> assertThatThrownBy(() -> new MoneyDto("100000000000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(MoneyValidator.IS_IN_BOUNDS.getErrorMessage()),

                () -> assertThat(MoneyValidator.IS_PARSEABLE.getPredicate().test("non digit"))
                        .isFalse()
        );
    }

}
