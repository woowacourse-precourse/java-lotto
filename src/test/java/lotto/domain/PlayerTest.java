package lotto.domain;

import lotto.exception.Check;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Player 테스트")
class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void compareLotto() {
    }

    @DisplayName("true case : 로또 구매 테스트")
    @Test
    void buyLotto() {
        List<Lotto> playerLottos = player.buyLotto(5000);
        int size = playerLottos.get(0).getNumbers().size();

        assertThat(playerLottos).hasSize(5);
        assertThat(size).isEqualTo(6);
    }

    @DisplayName("false case : 1000단위 미입력 로또 구매 테스트")
    @Test
    void buyLotto2() {
        assertThatThrownBy(() -> player.buyLotto(5001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}