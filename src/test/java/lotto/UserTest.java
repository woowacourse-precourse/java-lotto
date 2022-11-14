package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("로또 구입 금액이 1,000 원으로 나누어 떨어지지 않으면 예외 발생")
    @Test
    void createCost() {
        assertThatThrownBy(() -> new User(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }
}