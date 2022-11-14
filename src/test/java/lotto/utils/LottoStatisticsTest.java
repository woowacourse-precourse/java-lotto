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

}