package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Player 테스트")
class PlayerTest {
    private static final List<Integer> pickLotto = List.of(1, 2, 3, 4, 5, 6);
    private static final int pickPlusLotto = 7;
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @DisplayName("통합 로또 비교 테스트")
    @Test
    void compareLotto() {

        List<Lotto> lottos = new ArrayList<>();
        List<Integer> playerLottos = List.of(1, 2, 3, 4, 5, 7);
        Lotto playerLotto = new Lotto(playerLottos);
        lottos.add(playerLotto);

        HashMap<LottoResult, Integer> lottoResults = player.compareLottos(lottos, pickLotto, pickPlusLotto);

        for (LottoResult lottoResult : lottoResults.keySet()) {
            assertThat(lottoResult.getSameCount()).isEqualTo(5);
            assertThat(lottoResult.isSamePlusLotto()).isEqualTo(true);
        }

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