package lotto;

import constant.Invalid;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {
    Validate validate = new Validate();

    @Test
    public void NULL_테스트() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validate.validNull(null));
        assertThat(exception.getMessage()).contains(Invalid.NULL.toString());
    }

    @Test
    public void 정수_테스트_빈문자() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validate.validInt(""));
        assertThat(exception.getMessage()).contains(Invalid.NOT_INT.toString());
    }

    @Test
    public void 정수_테스트_문자() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validate.validInt("12L"));
        assertThat(exception.getMessage()).contains(Invalid.NOT_INT.toString());
    }

    @Test
    public void 정수_테스트_숫자() {
        assertThatCode(() -> validate.validInt("123")).doesNotThrowAnyException();
    }
}