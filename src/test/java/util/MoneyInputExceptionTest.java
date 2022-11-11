package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionTest {

    @DisplayName("구매 금액에 숫자가 아닌 값이 포함되면 예외를 발생한다.")
    @Test
    void enterMoneyWithNotNumeral() {
        String moneyInput = "1000a";
        Assertions.assertThatThrownBy(() -> Exception.isValidMoneyInput(moneyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 숫자로 입력해야 합니다.");
    }

    @DisplayName("구매 금액이 천원 단위가 아니면 예외를 발생한다.")
    @Test
    void enterMoneyWithNotValidMoneyUnit() {
        String moneyInput = "10001";
        Assertions.assertThatThrownBy(() -> Exception.isValidMoneyInput(moneyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
    }
}
