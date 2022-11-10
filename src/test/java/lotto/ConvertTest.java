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
}