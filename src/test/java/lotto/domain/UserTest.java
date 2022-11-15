package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @DisplayName("입력된 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void costUnitTest() {
        int cost = 2500;

        assertThatThrownBy(() -> new User().judgeCostValidate(cost))
                .isInstanceOf(IllegalArgumentException.class);
    }
}