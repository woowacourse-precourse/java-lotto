package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GetMoneyServiceTest {
    @DisplayName("GetMoneyService 생성자 예외처리 테스트")
    @Test
    void getMoneyTest() {
        assertThatThrownBy(() -> new GetMoneyService("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new GetMoneyService("8001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new GetMoneyService("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}