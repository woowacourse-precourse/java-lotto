package lotto.exception;

import lotto.constants.ErrorMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UtilClassCreateExceptionTest {
    @Test
    @DisplayName("Util 클래스 생성 시 예외 던지기")
    void throwUtilClassCreateExceptionT() {
        assertThatThrownBy(() -> {
            throw new UtilClassCreateException();
        })
                .isExactlyInstanceOf(UtilClassCreateException.class)
                .hasMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}