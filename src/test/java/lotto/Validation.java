package lotto;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Validation {

    @Nested
    class ValidateOneDigit {

        @Test
        void isInRange_string() {
            ValidationUtil.isValidNum("1");
            ValidationUtil.isValidNum("45");

            assertThatThrownBy(() -> ValidationUtil.isValidNum("0"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> ValidationUtil.isValidNum("46"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> ValidationUtil.isValidNum("-1"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class ValidateMultipleDigits {

        @Test
        void hasSixDigits() {
            assertThat(ValidationUtil.isValid("1,2,3,4,5,6")).isTrue();

            assertThatThrownBy(() -> ValidationUtil.isValid("1,2,3,4,5,6,7"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> ValidationUtil.isValid("1,2,3,4,5"))
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
