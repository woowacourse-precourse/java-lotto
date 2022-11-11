package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UtilClassCreateExceptionTest {
    @Test
    @DisplayName("Util 클래스 생성 시 예외 던지기")
    void throwUtilClassCreateExceptionT() {
        assertThatThrownBy(() -> {
            throw new UtilClassCreateException();
        }).isExactlyInstanceOf(UtilClassCreateException.class)
                .hasMessageStartingWith("[ERROR] 생성할 수 없는 유틸 클래스입니다.");
    }
}