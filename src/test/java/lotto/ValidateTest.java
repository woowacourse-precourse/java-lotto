package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {
    private final Validate validate = new Validate();

    @Test
    public void 나누어떨어지는_값() {
        assertThatCode(() -> validate.validDivisible(51_000)).doesNotThrowAnyException();
    }

    @Test
    public void 나누어떨어지지_않는_값() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> validate.validDivisible(51_001));
        assertThat(exception.getMessage()).contains("나누어떨어지지");
    }
}