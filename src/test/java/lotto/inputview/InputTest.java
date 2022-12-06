package lotto.inputview;

import lotto.Exception.Exception;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    @Test
    @DisplayName("구입 금액 입력 시 예외처리 (숫자 X)")
    void 구입금액() {
        Assertions.assertThatThrownBy(() -> Input.isValid("1000a")).isInstanceOf(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> Input.isValid("abcd"));
    }

    @Test
    @DisplayName("구입 금액 입력 시 예외처리 (천원 단위 X)")
    void 구입금액2() {
        assertThrows(IllegalArgumentException.class, () -> Input.isValid("1100"));
        assertThrows(IllegalArgumentException.class, () -> Input.isValid("11500"));
    }
}