package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lottos 클래스의 메서드를 테스트한다.")
class LottosTest {
    @DisplayName("돈이 1000원으로 안 나눠 떨어지면 오류를 던진다.")
    @Test
    void ifHaveRestMoneyThrowException() {
        assertThatThrownBy(() -> Lottos.purchaseLottos(12345))
                .isInstanceOf(IllegalArgumentException.class);
    }
}