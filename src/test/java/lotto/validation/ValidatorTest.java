package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValidatorTest {

    @Nested
    @DisplayName("숫자가 아닌 입력 검증 로직")
    class IsValidString {

        @Test
        @DisplayName("공백 입력은 예외 발생")
        void 공백_입력() {
            // given
            String input = " ";
            // when
            // then
            assertThatThrownBy(() -> Validator.validateStringIsNumeric(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("한글 입력은 예외 발생")
        void 한글_입력() {
            // given
            String input = "123ㄱ";
            // when
            // then
            assertThatThrownBy(() -> Validator.validateStringIsNumeric(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("영어 입력은 예외 발생")
        void 영어_입력() {
            // given
            String input = "a123";
            // when
            // then
            assertThatThrownBy(() -> Validator.validateStringIsNumeric(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("기호 입력은 예외 발생")
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
    @DisplayName("음수값 price 범위(양수)는 예외 발생")
    void 음수_입력() {
        // given
        int price = -1000;
        // when
        // then
        assertThatThrownBy(() -> Validator.validatePriceRange(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("일치하지 않는 List 사이즈 검증")
    void 사이즈_검증() {
        // given
        List<Integer> lst = List.of(1, 2, 3);
        // when
        int size = 4;
        // then
        assertThatThrownBy(() -> Validator.validateSize(lst, size))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("범위를 벗어난 숫자는 예외 발생")
    void 숫자_범위_검증() {
        // given
        List<Integer> lst = List.of(1, 2, 48);
        // when
        int startRange = 1;
        int endRange = 45;
        // then
        assertThatThrownBy(() -> Validator.validateNumbersRange(lst))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 리스트는 예외 발생")
    void 중복_리스트_검증() {
        // given
        List<Integer> lst = List.of(1, 1, 2);
        // when
        // then
        assertThatThrownBy(() -> Validator.validateNonDuplicatedList(lst))
                .isInstanceOf(IllegalArgumentException.class);
    }
}