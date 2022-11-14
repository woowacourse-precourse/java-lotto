package lotto;

import lotto.model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPlayerByNotDividedBy1000() {
        assertThatThrownBy(() -> new Player("5050"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수면 예외가 발생한다.")
    @Test
    void createPlayerByMinusValue() {
        assertThatThrownBy(() -> new Player("-5000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 규격 이외면 예외가 발생한다.")
    @Test
    void createPlayerByInvalidValue() {
        assertThatThrownBy(() -> new Player("이상한값"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("티켓 개수 = 구입 금액 / 1000 이어야 한다.")
    @Test
    void testTicketNumberEqualsPurchaseAmountDividedBy1000() {
        Player player = new Player("10000");
        assertThat(player.getTicketNumber()).isEqualTo(10);
    }
}
