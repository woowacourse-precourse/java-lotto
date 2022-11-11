package lotto;

import lotto.exception.ExceptionValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoPurchaseTest {

    @DisplayName("입력한 금액이 1000원으로 나누어 떨어지지 않으면 Exception발생")
    @Test
    void checkException() {
        assertThatThrownBy(() -> ExceptionValidation.validateException(1001))
                .hasMessageContaining("[ERROR] 복권 하나는 1000원입니다. 1000원 단위로 입력해주세요.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}
