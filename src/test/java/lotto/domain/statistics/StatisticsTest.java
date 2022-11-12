package lotto.domain.statistics;

import lotto.domain.money.Money;
import lotto.domain.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.rank.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class StatisticsTest {

    @Test
    @DisplayName("통계는 원금과 당첨 등수들을 통해 생성된다.")
    void createByPrincipleAndRanks() {
        // given
        Money principle = Money.valueOf(8000);
        List<Rank> ranks = List.of(FIFTH, FIFTH, UNWINNABLE, SECOND, THIRD, FIFTH, FOURTH);

        // when, then
        assertThatCode(() -> Statistics.of(principle, ranks))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("통계로부터 몇등이 몇번 당첨되었는지 확인할 수 있다.")
    void checkNumberOfWins() {
        // given
        Money principle = Money.valueOf(8000);
        List<Rank> ranks = List.of(FIFTH, FIFTH, UNWINNABLE, SECOND, THIRD, FIFTH, FOURTH);
        Statistics statistics = Statistics.of(principle, ranks);

        // when
        long count = statistics.count(FIFTH);

        // then
        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("통계로부터 수익률을 받아올 수 있다.")
    void getYield() {
        // given
        Money principle = Money.valueOf(8000);
        List<Rank> ranks = List.of(FIFTH);
        Statistics statistics = Statistics.of(principle, ranks);

        // when
        double yield = statistics.yield();

        // then
        assertThat(yield).isEqualTo(62.5);
    }
}