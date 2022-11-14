package lotto.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ValidatorTest {
    @Nested
    class isNumberForChar {
        @DisplayName("주어진 문자가 숫자가 아닌 경우")
        @Test
        void isNumberTest_숫자가아닌경우() {
            char input = 'n';

            Assertions.assertThatThrownBy(
                            () -> Validator.isNumber(input)
                    )
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("주어진 문자가 숫자인 경우")
        @Test
        void isNumberTest_숫자인경우() {
            char input = '4';

            Assertions.assertThat(Validator.isNumber(input)).isTrue();
        }
    }

    @Nested
    class isNumberForString {
        @DisplayName("주어진 문자열이 숫자가 아닌 경우")
        @Test
        void isNumberTest_숫자가아닌경우() {
            String input = "asdfadf1";

            Assertions.assertThatThrownBy(
                            () -> Validator.isNumber(input)
                    )
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("주어진 문자열이 숫자인 경우")
        @Test
        void isNumberTest_숫자인경우() {
            String input = "1234";

            Assertions.assertThat(Validator.isNumber(input)).isTrue();
        }
    }

    @Nested
    class isInRange {
        @DisplayName("주어진 리스트의 모든 숫자가 범위 내인 경우")
        @Test
        void isInRange_범위안인경우() {
            Assertions.assertThat(Validator.isInRange(List.of(0,1,2,3,4,5))).isFalse();

        }

        @DisplayName("주어진 리스트 중 특정 숫자가 범위 밖에 있는 경우")
        @Test
        void isInRange_범위밖인경우() {
            Assertions.assertThat(Validator.isInRange(List.of(1,2,3,4,5,6))).isTrue();
        }
    }

    @Nested
    class isDuplicate {
        @DisplayName("주어진 리스트에 중복이 존재하지 않는 경우")
        @Test
        void isDuplicate_중복없는경우() {
            Assertions.assertThat(Validator.isDuplicate(List.of(1,2,3,4,5,6))).isFalse();
        }

        @DisplayName("주어진 리스트에 중복이 존재하지 않는 경우")
        @Test
        void isDuplicate_중복있는경우() {
            Assertions.assertThat(Validator.isDuplicate(List.of(1,2,3,4,5,5))).isTrue();

        }
    }

    @Nested
    class isHundredUnit {
        @DisplayName("주어진 숫자가 1000원 단위인 경우")
        @Test
        void isHundredTest_1000원단위() {
            Assertions.assertThat(Validator.isHundredUnit(12000)).isTrue();
        }

        @DisplayName("주어진 숫자가 1000원 단위가 아닌 경우")
        @Test
        void isHundredTest_1000원단위아님() {
            Assertions.assertThatThrownBy(
                            () -> Validator.isHundredUnit(12314)
                    )
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
