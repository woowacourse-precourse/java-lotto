package lotto;

import lotto.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @DisplayName("구입 금액에 따른 로또 발행 수량 구하기")
    @Test
    void createLottoCount() {
        assertThat(new Player(8000).getLottoCount())
                .isEqualTo(8);
    }
    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPlayerByIndivisibleWonUnit() {
        assertThatThrownBy(() -> new Player(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위만 가능합니다.");
    }

    @DisplayName("구입 금액이 0원이면 예외가 발생한다.")
    @Test
    void createPlayerByZeroMoney() {
        assertThatThrownBy(() -> new Player(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위만 가능합니다.");
    }
}
