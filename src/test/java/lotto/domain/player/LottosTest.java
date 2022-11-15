package lotto.domain.player;

import lotto.domain.game.generator.NumberGenerator;
import lotto.domain.game.generator.RandomNumberGenerator;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

class LottosTest {

    Lottos lottos;
    Player player;

    @BeforeEach
    void init() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        lottos = new Lottos(numberGenerator);
        player = Mockito.mock(Player.class);
    }

    @Test
    @DisplayName("발행한 로또의 개수는 플레이어가 구매한 로또의 수와 같다.")
    void 로또_개수_확인_테스트() {
        when(player.getLottoCount()).thenReturn(5);
        lottos.generateLottos(player.getLottoCount());
        assertThat(lottos.getLottos().size()).isEqualTo(player.getLottoCount());
    }

    @Test
    @DisplayName("발행한 로또의 수는 오름차순 이어야 한다.")
    void 오름차순_확인_테스트() {
        when(player.getLottoCount()).thenReturn(5);
        lottos.generateLottos(player.getLottoCount());

        for (Lotto lotto : lottos.getLottos()) {
            assertThat(lotto.getNumbers()).isSortedAccordingTo(Comparator.naturalOrder());
        }
    }
}
