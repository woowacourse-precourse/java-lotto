package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.User;

class UserTest {
    @DisplayName("로또 구입 금액 예외 테스트")
    @Test
    void userPayPriceExceptionTest() {
        User user = new User();
        assertThatThrownBy(() -> user.buyLotto("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 구입 금액 입력 예외 테스트")
    @Test
    void userInputPriceExceptionTest() {
        User user = new User();
        assertThatThrownBy(() -> user.buyLotto("lotto"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
