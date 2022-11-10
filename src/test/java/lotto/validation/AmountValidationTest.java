package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountValidationTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private String amount;
    private AmountValidation validation;

    @BeforeEach
    void beforeEach() {
        amount = "";
        validation = new AmountValidation();
    }

    @DisplayName("아무것도 입력하지 않은 경우")
    @Test
    void isNullTest() {
        // given
        amount = "";

        // when, then
        assertThatThrownBy(() -> validation.isNull(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("숫자가 아닌 경우")
    @Test
    void isNumberTest() {
        // given
        amount = "만";

        // when, then
        assertThatThrownBy(() -> validation.isNumber(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("0을 입력한 경우")
    @Test
    void isZeroTest() {
        // given
        amount = "0";

        // when, then
        assertThatThrownBy(() -> validation.isZero(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("1,000원 단위로 나누어 떨어지지 않는 경우(잔돈이 생기는 경우)")
    @Test
    void hasChangesTest() {
        // given
        amount = "12500";

        // when, then
        assertThatThrownBy(() -> validation.hasChanges(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}