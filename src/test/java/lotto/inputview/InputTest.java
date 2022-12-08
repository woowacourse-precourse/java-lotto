package lotto.inputview;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    InputMoney input = new InputMoney();
    @Test
    @DisplayName("구입 금액 입력 시 예외처리 (숫자 X)")
    void 구입금액() {
        Assertions.assertThatThrownBy(() -> input.isValid("1000a")).isInstanceOf(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> input.isValid("abcd"));
    }

    @Test
    @DisplayName("구입 금액 입력 시 예외처리 (천원 단위 X)")
    void 구입금액2() {
        assertThrows(IllegalArgumentException.class, () -> input.isValid("1100"));
        assertThrows(IllegalArgumentException.class, () -> input.isValid("11500"));
    }
}