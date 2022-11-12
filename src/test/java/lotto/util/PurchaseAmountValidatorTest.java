package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {
    private PurchaseAmountValidator validator = new PurchaseAmountValidator();

    @Nested
    @DisplayName("구입 금액은 숫자이다.")
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

    @Nested
    @DisplayName("구입 금액은 양수이다.")
    class IsPositiveNumberTest {
        @Test
        void 양수일_경우() {
            assertThat(validator.isPositiveNumber("123")).isEqualTo(true);
        }

        @Test
        void 음수일_경우() {
            assertThat(validator.isPositiveNumber("-1000")).isEqualTo(false);
        }

        @Test
        void 값이_0일_경우() {
            assertThat(validator.isPositiveNumber("0")).isEqualTo(false);
        }
    }

    @Nested
    @DisplayName("구입 금액은 1000으로 나누어 떨어진다.")
    class isDivisibleBy1000Test {
        @Test
        void 나누어_떨어질_경우_1() {
            assertThat(validator.isDivisibleBy1000("1000")).isEqualTo(true);
        }

        @Test
        void 나누어_떨어질_경우_2() {
            assertThat(validator.isDivisibleBy1000("15000")).isEqualTo(true);
        }

        @Test
        void 나누어_떨어지지_않을_경우_1() {
            assertThat(validator.isDivisibleBy1000("1234")).isEqualTo(false);
        }

        @Test
        void 나누어_떨어지지_않을_경우_2() {
            assertThat(validator.isDivisibleBy1000("999")).isEqualTo(false);
        }
    }

    @Nested
    @DisplayName("구입 금액이 유효하지 않으면 예외가 발생한다.")
    class isValidatePurchaseAmountTest {
        @Test
        void 숫자가_아닌_경우_예외_테스트() {
            assertThatThrownBy(() -> validator.validatePurchaseAmount("1000aa"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 양수가_아닌_경우_예외_테스트() {
            assertThatThrownBy(() -> validator.validatePurchaseAmount("-1000"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 나누어_떨어지지_않을_경우_예외_테스트() {
            assertThatThrownBy(() -> validator.validatePurchaseAmount("1234"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}