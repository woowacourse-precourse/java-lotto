package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("구입 금액이 숫자가 아니면 예외 발생")
    @Test
    void createUserMoneyNotNumeric() {
        Assertions.assertThatThrownBy(() ->
                new User("string")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000단위가 아니면 예외 발생")
    @Test
    void createUserMoneyNotThousandUnit() {
        Assertions.assertThatThrownBy(() ->
                new User("1550")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수면 예외 발생")
    @Test
    void createUserMoneyNegativeNumber() {
        Assertions.assertThatThrownBy(() ->
                new User("-1000")).isInstanceOf(IllegalArgumentException.class);
    }
}
