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

    @Test
    public void 로또_형태() {
        assertThatCode(() -> validate.validWinLottoForm(new String[] {"1", "4", "7", "14", "28", "37"}))
                .doesNotThrowAnyException();
    }

    @Test
    public void 로또_형태_아님() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () ->
                        validate.validWinLottoForm(new String[] {"1", "4", "7", "14", "28"}));
        assertThat(exception.getMessage()).contains("입력값을 로또 형태로 전환할 수 없습니다.");
    }
}