package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    private User user = new User();

    @Test
    @DisplayName("유저가 구매한 금액이 1000원 단위가 아니라면 에러 발생")
    void validatePayMoney(){
        assertThatThrownBy(()->{
            user.validateMoney(12345);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}