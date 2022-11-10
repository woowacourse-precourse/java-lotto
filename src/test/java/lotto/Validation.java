package lotto;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Validation {

    @Nested
    class ValidateOneDigit {

        @Test
        void isInRange_string() {
            ValidationUtil.isValidNumber("1");
            ValidationUtil.isValidNumber("45");

            assertThatThrownBy(() -> ValidationUtil.isValidNumber("0"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> ValidationUtil.isValidNumber("46"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> ValidationUtil.isValidNumber("-1"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class ValidateMultipleDigits {

        @Test
        void invalidInput() {
            assertThatThrownBy(() -> ValidationUtil.isValid("1,2,3,4,5,6!7"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> ValidationUtil.isValid("1, 2, 3, 4, 5, 6, 7"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> ValidationUtil.isValid("!,*,3,4,5,6,7"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void invalidCount() {
            assertThatThrownBy(() -> ValidationUtil.isValid("1,2,3,4,5,6,7"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> ValidationUtil.isValid("1,2,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void distinctDigits() {
            assertThat(ValidationUtil.isValid("1,2,3,4,5,6")).isTrue();
            assertThatThrownBy(() -> ValidationUtil.isValid("1,2,3,4,6,6"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> ValidationUtil.isValid("1,2,3,2,6,6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void isValid() {
            assertThat(ValidationUtil.isValid("1,2,3,4,5,6")).isTrue();
            assertThat(ValidationUtil.isValid("1,2,3,4,5,45")).isTrue();

            assertThatThrownBy(() -> ValidationUtil.isValid("1,2,3,4,5,46"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> ValidationUtil.isValid("1,2,3,4"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
    
}
