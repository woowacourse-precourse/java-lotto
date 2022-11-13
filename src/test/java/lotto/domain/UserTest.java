package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {
    @DisplayName("입력한 금액이 1000원 단위가 아닐 때 User 생성자 함수에서 에러 발생")
    @Test
    void createUserWithInvalidAmountOfMoney() {
        assertThatThrownBy(() -> new User(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위로")
                .hasMessageNotContaining("[ERROR]");
    }
}
