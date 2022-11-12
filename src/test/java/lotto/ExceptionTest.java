package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {
    @DisplayName("입력된 구입 금액이 정수가 아니면 예외가 발생한다.")
    @Test
    void createMoneyString() {
        assertThatThrownBy(() -> Exception.isInteger("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}