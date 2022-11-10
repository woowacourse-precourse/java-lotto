package lotto;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Validation {

    @Nested
    class ValidateOneDigit {
        @Test
        void isInRange_int() {
            assertThat(ValidationUtil.isInRange(1)).isTrue();
            assertThat(ValidationUtil.isInRange(45)).isTrue();
            assertThat(ValidationUtil.isInRange(0)).isFalse();
            assertThat(ValidationUtil.isInRange(46)).isFalse();
            assertThat(ValidationUtil.isInRange(-1)).isFalse();
        }

        @Test
        void isInRange_string() {
            assertThat(ValidationUtil.isInRange("1")).isTrue();
            assertThat(ValidationUtil.isInRange("45")).isTrue();

            assertThatThrownBy(() -> ValidationUtil.isInRange("0"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> ValidationUtil.isInRange("46"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> ValidationUtil.isInRange("-1"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class ValidateMultipleDigits {

        @Test
        void hasSixDigits() {
            assertThat(ValidationUtil.isValidCount("1,2,3,4,5,6")).isTrue();

            assertThatThrownBy(() -> ValidationUtil.isValidCount("1,2,3,4,5,6,7"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> ValidationUtil.isValidCount("1,2,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void isValid() {
            assertThat(ValidationUtil.isValidCount("1,2,3,4,5,6")).isTrue();
            assertThat(ValidationUtil.isValidCount("1,2,3,4,5,45")).isTrue();

            assertThatThrownBy(() -> ValidationUtil.isValidCount("1,2,3,4,5,46"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> ValidationUtil.isValidCount("1,2,3,4"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
    
}
