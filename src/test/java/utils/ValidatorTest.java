package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    @DisplayName("사용자로부터 보너스 번호를 입력받으면 ")
    @Nested
    class BonusNumberTest {

        @DisplayName("올바른 값으로 인해 검증에 통과한다")
        @Test
        void 올바른_보너스_번호를_입력받아_검증에_통과한다() {
            // given
            List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);

            // when & then
            assertThatCode(() -> Validator.checkBonusNumberIsValid("10", winNumbers))
                    .doesNotThrowAnyException();
        }

        @DisplayName("잘못된 값으로 인해 예외가 던져진다.")
        @Test
        void 잘못된_보너스_번호를_입력받아_검증에_통과하지_못한다() {
            // given
            List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);

            // when & then
            IllegalArgumentException duplicatedEx = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validator.checkBonusNumberIsValid("1", winNumbers)
            );
            IllegalArgumentException underRangeEx = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validator.checkBonusNumberIsValid("0", winNumbers)
            );
            IllegalArgumentException overRangeEx = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validator.checkBonusNumberIsValid("46", winNumbers)
            );
            IllegalArgumentException includeNotNumberEx = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validator.checkBonusNumberIsValid("1;", winNumbers)
            );

            assertAll(
                    () -> assertThat(duplicatedEx.getMessage()).startsWith("[ERROR]"),
                    () -> assertThat(underRangeEx.getMessage()).startsWith("[ERROR]"),
                    () -> assertThat(overRangeEx.getMessage()).startsWith("[ERROR]"),
                    () -> assertThat(includeNotNumberEx.getMessage()).startsWith("[ERROR]")
            );
        }
    }
}