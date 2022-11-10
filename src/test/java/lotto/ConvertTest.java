package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {
    private final Convert convert = new Convert();

    @Test
    public void 정수_테스트_숫자() {
        assertThatCode(() -> convert.toInt("123")).doesNotThrowAnyException();
    }

    @Test
    public void 정수_테스트_INT_최대를_벗어날_경우() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> convert.toInt("999999999999999999999"));
        assertThat(exception.getMessage()).contains("입력값을 정수로 변환할 수 없습니다.");
    }

    @Test
    public void 로또갯수_테스트() {
        assertThatCode(() -> convert.toLottoCount(50_000)).doesNotThrowAnyException();
    }

    @Test
    public void 로또갯수_테스트_나누어떨어지지_않음() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> convert.toLottoCount(50_001));
        assertThat(exception.getMessage()).contains("나누어떨어지지");
    }

    @Test
    public void 로또_당첨_번호() {
        assertThatCode(() -> convert.toWinLottoNumbers("1,4,7,14,28,36")).doesNotThrowAnyException();
    }

    @Test
    public void 로또_당첨_번호_갯수초과() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () ->
                        convert.toWinLottoNumbers("1,4,7,14,28,36,44"));
        assertThat(exception.getMessage()).contains("입력값을 로또 형태로 전환할 수 없습니다.");
    }

    @Test
    public void 로또_당첨_번호_범위초과() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () ->
                        convert.toWinLottoNumbers("1,4,7,14,28,46"));
        assertThat(exception.getMessage()).contains("로또 번호의 범위를 넘어갔습니다.");
    }

    @Test
    public void 로또_당첨_번호_중복() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () ->
                        convert.toWinLottoNumbers("1,4,7,14,28,7"));
        assertThat(exception.getMessage()).contains("중복된 로또 번호가 존재합니다.");
    }
}