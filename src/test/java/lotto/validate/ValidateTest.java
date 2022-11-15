package lotto.validate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidateTest {
    @Nested
    class PurchasingNumberTest {

        @Test
        @DisplayName("입력값이 null이거나 빈 문자열이면 예외를 발생한다.")
        void ShouldThrowExceptionWhenIsNullOrEmpty() {
            String sample = "";

            assertThatThrownBy(() -> {
                Validate.validateIsNullOrEmpty(sample);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

        @Test
        @DisplayName("입력값이 천원 단위가 아니면 예외를 발생한다.")
        void ShouldThrowExceptionWhenIsNotThousandWon() {
            //given
            String sample = "1001";

            assertThatThrownBy(() -> {
                Validate.validateEndsWithThreeZeros(sample); //when
            }).isInstanceOf(IllegalArgumentException.class) //then
                    .hasMessageContaining("[ERROR]");
        }

        @Test
        @DisplayName("입력값이 숫자가 아니면 예외를 발생한다.")
        void ShouldThrowExceptionWhenIsNotNumber() {
            //given
            String sample = "ab000";

            assertThatThrownBy(() -> {
                Validate.validateIsNumber(sample);   //when
            }).isInstanceOf(IllegalArgumentException.class) //then
                    .hasMessageContaining("[ERROR]");
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "abc", "20002", "ab000"})
        @DisplayName("잘못된 금액을 입력했을 때 예외를 발생한다.")
        void ShouldThrowExceptionIsNotPurchasingMoney(String money) {
            assertThatThrownBy(() -> {
                ValidatePurchasingAmount.validate(money);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

}
