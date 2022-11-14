package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    private final Lottos lottos = new Lottos();

    @Test
    @DisplayName("로또 추가 테스트")
    void addLottoToLottos() {
        assertThat(lottos.getCount()).isEqualTo(0);
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(11, 12, 13, 14, 15, 16)));
        lottos.add(new Lotto(List.of(31, 36, 38, 40, 42, 44)));
        lottos.add(new Lotto(List.of(1, 3, 5, 7, 9, 45)));
        lottos.add(new Lotto(List.of(1, 10, 20, 30, 40, 45)));
        assertThat(lottos.getCount()).isEqualTo(5);
    }
}
