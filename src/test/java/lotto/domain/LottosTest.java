package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    final int LOTTO_COUNT = 4;

    @DisplayName("생성된 리스트내의 객체가 Lotto인지 확인한다.")
    @Test
    void checkLottoTypeInLottos() {
        Lottos lottos = new Lottos(Lottos.createLottoList(LOTTO_COUNT));

        assertThat(lottos.getLottos().get(0)).isInstanceOf(Lotto.class);
    }

    @DisplayName("주어진 금액에 맞는 복권을 생성하는지 확인한다.")
    @Test
    void createLottoList() {
        Lottos lottos = new Lottos(Lottos.createLottoList(LOTTO_COUNT));

        assertThat(lottos.getLottos().size()).isEqualTo(LOTTO_COUNT);
    }
}