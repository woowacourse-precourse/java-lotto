package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Player 테스트")
class PlayerTest {

    @Test
    void compareLotto() {
    }

    @DisplayName("로또 구매 테스트")
    @Test
    void buyLotto() {
        Player player = new Player();

        List<Lotto> playerLottos = player.buyLotto(5000);
        int size = playerLottos.get(0).getNumbers().size();

        assertThat(playerLottos).hasSize(5);
        assertThat(size).isEqualTo(6);
    }
}