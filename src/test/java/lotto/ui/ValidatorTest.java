package lotto.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

}
