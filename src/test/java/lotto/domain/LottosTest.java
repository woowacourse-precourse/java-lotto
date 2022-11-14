package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @DisplayName("구매한 수량에 맞게 로또들이 리스트에 잘 추가되어지는지 테스트한다.")
    @Test
    void generateLottos() {
        //given
        Lottos lottos = new Lottos();
        int lottoCount = 8;
        //when
        lottos.generateLottos(lottoCount);
        //then
        assertThat(lottos.getLottos()
                         .size()).isEqualTo(lottoCount);
    }

    @DisplayName("구매한 로또들이 정렬되어서 반환되는지 테스트한다.")
    @Test
    void checkLottos() {
        //given
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(List.of(6, 5, 4, 3, 2, 1)));

        //when
        Lottos purchasedLottos = lottos.checkLottos();
        //then
        for (int i = 0; i < 6; i++) {
            assertThat(purchasedLottos.getLottos()
                                      .get(0)
                                      .getNumbers()
                                      .get(i)).isEqualTo(i + 1);
        }
    }

    @DisplayName("당첨 로또와 보너스를 비교하여 구매한 로또 수 만큼 결과를 반환하는지 테스트한다.")
    @Test
    void generateResults() {
        //given
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(List.of(6, 5, 4, 3, 2, 1)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        //when
        Results results = lottos.generateResults(winningLotto, bonus);
        //then
        assertThat(results.getResults()
                          .size()).isEqualTo(2);
    }
}