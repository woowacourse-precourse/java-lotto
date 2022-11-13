package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValidatorTest {

    @Nested
    @DisplayName("숫자가 아닌 입력 검증 로직")
    class IsValidString {

        @Test
        @DisplayName("공백 입력")
        void 공백_입력() {
            // given
            String input = " ";
            // when
            // then
            assertThatThrownBy(() -> Validator.validateStringIsNumeric(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("한글 입력")
        void 한글_입력() {
            // given
            String input = "123ㄱ";
            // when
            // then
            assertThatThrownBy(() -> Validator.validateStringIsNumeric(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("영어 입력")
        void 영어_입력() {
            // given
            String input = "a123";
            // when
            // then
            assertThatThrownBy(() -> Validator.validateStringIsNumeric(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("기호 입력")
        void 기호_입력() {
            // given
            String input = "-+&123";
            // when
            // then
            assertThatThrownBy(() -> Validator.validateStringIsNumeric(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("음수값 price 범위(양수) 검증")
    void 음수_입력(){
        // given
        long price = -1000;
        // when
        // then
        assertThatThrownBy(() -> Validator.validatePriceRange(price))
                .isInstanceOf(IllegalArgumentException.class);
    }


}