package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @DisplayName("금액의 입력값이 천 단위가 아닐시 에러가 발생한다.")
    @Test
    void inputUserMoneyIncorrect() {
        assertThatThrownBy(() -> new User(1500)).isInstanceOf(IllegalArgumentException.class).isEqualTo("[ERROR] 금액 입력값은 1000원 단위여야 합니다");
    }
}