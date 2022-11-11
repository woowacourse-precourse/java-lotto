package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {
    private final Validate validate = new Validate();

    @Test
    public void 나누어떨어지는_값() {
        assertThatCode(() ->
                validate.validDivisible(51_000, 1000)).doesNotThrowAnyException();
    }

    @Test
    public void 나누어떨어지지_않는_값() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () ->
                        validate.validDivisible(51_001, 1000));
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

    @Test
    public void 로또_번호_범위내() {
        assertThatCode(() -> validate.validLottoNumber(39))
                .doesNotThrowAnyException();
    }

    @Test
    public void 로또_번호_범위밖() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () ->
                        validate.validLottoNumber(48));
        assertThat(exception.getMessage()).contains("로또 번호의 범위를 넘어갔습니다.");
    }

    @Test
    public void 로또_번호_중복되지_않음() {
        assertThatCode(() -> validate.validDuplicate(List.of(1, 4, 7, 14, 36, 44)))
                .doesNotThrowAnyException();
    }

    @Test
    public void 로또_번호_중복() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () ->
                        validate.validDuplicate(List.of(1, 4, 7, 14, 4, 44)));
        assertThat(exception.getMessage()).contains("중복된 로또 번호가 존재합니다.");
    }
}