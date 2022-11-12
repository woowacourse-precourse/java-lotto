package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {
    PurchaseAmountValidator validator = new PurchaseAmountValidator();

    @Nested
    @DisplayName("구매 금액은 숫자이다.")
    class IsNumberTest {
        @Test
        void 숫자일_경우() {
            assertThat(validator.isNumber("123")).isEqualTo(true);
        }

        @Test
        void 숫자와_문자가_함께일_경우() {
            assertThat(validator.isNumber("123a")).isEqualTo(false);
        }

        @Test
        void 문자일_경우() {
            assertThat(validator.isNumber("aaa")).isEqualTo(false);
        }
    }
}