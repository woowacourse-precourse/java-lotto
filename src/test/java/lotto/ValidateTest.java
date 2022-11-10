package lotto;

import constant.Invalid;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {
    Validate validate = new Validate();

    @Test
    public void NULL_테스트() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validate.validNull(null));
        assertThat(exception.getMessage()).contains(Invalid.NULL.toString());
    }
}