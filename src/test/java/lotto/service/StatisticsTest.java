package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinLotto;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    Statistics statistics = new Statistics();

    @Test
    public void 로또_통계() {
        WinLotto winLotto = new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Map<Prize, Integer> produce = statistics.produce(winLotto,
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 11)),
                        new Lotto(List.of(1, 2, 3, 4, 7, 11)),
                        new Lotto(List.of(1, 2, 3, 7, 8, 11)),
                        new Lotto(List.of(4, 5, 6, 7, 8, 9)),
                        new Lotto(List.of(11, 12, 13, 14, 15, 16))
                ));

        assertThat(produce.size()).isEqualTo(5);
        assertThat(produce.getOrDefault(Prize.NONE, 0)).isEqualTo(0);
        assertThat(produce.getOrDefault(Prize.FIFTH, 0)).isEqualTo(2);
        assertThat(produce.getOrDefault(Prize.FOURTH, 0)).isEqualTo(1);
        assertThat(produce.getOrDefault(Prize.THIRD, 0)).isEqualTo(1);
        assertThat(produce.getOrDefault(Prize.SECOND, 0)).isEqualTo(1);
        assertThat(produce.getOrDefault(Prize.FIRST, 0)).isEqualTo(1);
    }

}