package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CommonInputExceptionTest {

    @Test
    void 입력이_아무것도_없을_때() {
        assertThatThrownBy(() -> CommonInputException.checkEmptyInput("", "입력을"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}