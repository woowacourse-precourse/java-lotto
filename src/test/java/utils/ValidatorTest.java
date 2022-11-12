package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    @DisplayName("사용자로부터 로또 구입 금액을 입력받으면 ")
    @Nested
    class LottoPurchaseAmountTest {

        @DisplayName("올바른 값으로 인해 검증에 통과한다.")
        @Test
        void 올바른_로또_구입_금액을_입력받아_검증에_통과한다() {
            // given

            // when & then
            assertAll(
                    () -> assertThatCode(() -> Validator.checkLottoPurchaseAmountIsValid("1000"))
                            .doesNotThrowAnyException(),
                    () -> assertThatCode(() -> Validator.checkLottoPurchaseAmountIsValid("10000"))
                            .doesNotThrowAnyException(),
                    () -> assertThatCode(() -> Validator.checkLottoPurchaseAmountIsValid("2100000000"))
                            .doesNotThrowAnyException()
            );
        }

        @DisplayName("잘못된 값으로 인해 예외가 던져진다.")
        @Test
        void 잘못된_로또_구입_금액을_입력받아_검증에_통과하지_못한다() {
            // given

            // when & then
            IllegalArgumentException includeNotNumberEx = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validator.checkLottoPurchaseAmountIsValid("1000j")
            );

            IllegalArgumentException outOfRangeEx = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validator.checkLottoPurchaseAmountIsValid("0")
            );

            IllegalArgumentException notDivideByThousandUnitEx = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validator.checkLottoPurchaseAmountIsValid("999")
            );

            assertAll(
                    () -> assertThat(includeNotNumberEx.getMessage()).startsWith("[ERROR]"),
                    () -> assertThat(outOfRangeEx.getMessage()).startsWith("[ERROR]"),
                    () -> assertThat(notDivideByThousandUnitEx.getMessage()).startsWith("[ERROR]")
            );
        }
    }

    @DisplayName("사용자로부터 당첨 번호를 입력받으면 ")
    @Nested
    class WinNumbersTest {

        @DisplayName("올바른 값으로 인해 검증에 통과한다.")
        @Test
        void 올바른_당첨_번호를_입력받아_검증에_통과한다() {
            // given

            // when & then
            assertAll(
                    () -> assertThatCode(() -> Validator.checkWinsNumberIsValid("1,2,3,4,5,6"))
                            .doesNotThrowAnyException(),
                    () -> assertThatCode(() -> Validator.checkWinsNumberIsValid("13,24,36,45,1,5"))
                            .doesNotThrowAnyException()
            );
        }

        @DisplayName("잘못된 값으로 인해 예외가 던져진다.")
        @Test
        void 잘못된_당첨_번호를_입력받아_검증에_통과하지_못한다() {
            // given

            // when & then
            IllegalArgumentException underRangeEx = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validator.checkWinsNumberIsValid("0,1,2,3,4,5")
            );
            IllegalArgumentException overRangeEx = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validator.checkWinsNumberIsValid("1,2,3,4,5,46")
            );
            IllegalArgumentException includeNotNumberEx = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validator.checkWinsNumberIsValid("0,1,2,3,4,5")
            );
            IllegalArgumentException duplicatedEx = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validator.checkWinsNumberIsValid("1,2,3,4,5,5")
            );

            assertThat(underRangeEx.getMessage()).startsWith("[ERROR]");
            assertThat(overRangeEx.getMessage()).startsWith("[ERROR]");
            assertThat(includeNotNumberEx.getMessage()).startsWith("[ERROR]");
            assertThat(duplicatedEx.getMessage()).startsWith("[ERROR]");
        }
    }
}