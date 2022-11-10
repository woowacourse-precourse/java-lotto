package lotto;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Validation {

    @Nested
    class ValidateOneDigit {
        @Test
        void isInRange() {
            assertThat(ValidationUtil.isInRange(1)).isTrue();
            assertThat(ValidationUtil.isInRange(45)).isTrue();
            assertThat(ValidationUtil.isInRange(0)).isFalse();
            assertThat(ValidationUtil.isInRange(46)).isFalse();
            assertThat(ValidationUtil.isInRange(-1)).isFalse();
        }
    }
}
