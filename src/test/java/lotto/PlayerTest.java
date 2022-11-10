package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @DisplayName("10000원이 주어졌을 때 살수있는 로또의 개수는 10개")
    @Test
    void canByLottoCount() {
        Player player = new Player();
        int count = player.canBuyLottoCount(10000);
        assertThat(count).isEqualTo(10);
    }

    @DisplayName("구임 금액이 1000으로 나누어 떨어지지 않으면 예외 발생")
    @Test
    void validatePrice() {
        assertThatThrownBy(() -> {
            Player player = new Player();
            player.canBuyLottoCount(1350);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("주어진 금액 많큼 로또를 발행하는 기능")
    @Test
    void buyLottos() {
        Player player = new Player();
        List<List<Integer>> lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8)
        );
        List<Lotto> lottos = player.buyLottos(3000, lottoNumbers);
        assertThat(lottos.size()).isEqualTo(3);
    }
}
