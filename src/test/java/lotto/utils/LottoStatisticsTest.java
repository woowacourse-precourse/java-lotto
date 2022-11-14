package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Win;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @Test
    @DisplayName("1등 1개, 2등 1개, 3등 1개")
    void getLottoStatistics() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,9)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,7)));
        lottos.add(new Lotto(List.of(1,2,10,11,12,13)));

        Win win = new Win(List.of(1, 2, 3, 4, 5, 6));
        win.setBonus(9);

        // when
        LottoStatistics statistics = new LottoStatistics(lottos, win);

        // then
        assertThat(statistics.getFirstCount()).isEqualTo(1);
        assertThat(statistics.getSecondCount()).isEqualTo(1);
        assertThat(statistics.getThirdCount()).isEqualTo(1);
        assertThat(statistics.getFourthCount()).isEqualTo(0);
        assertThat(statistics.getFifthCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("8000원으로 5등 1개된 경우, 수익률 62.5 ")
    void getRateOfResult() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));


        Win win = new Win(List.of(1, 2, 3, 4, 5, 6));
        win.setBonus(7);

        // when
        LottoStatistics statistics = new LottoStatistics(lottos, win);

        // then
        assertThat(statistics.getFirstCount()).isEqualTo(0);
        assertThat(statistics.getSecondCount()).isEqualTo(0);
        assertThat(statistics.getThirdCount()).isEqualTo(0);
        assertThat(statistics.getFourthCount()).isEqualTo(0);
        assertThat(statistics.getFifthCount()).isEqualTo(1);
        assertThat(statistics.getRateOfResult(8000)).isEqualTo(62.5);
    }

}