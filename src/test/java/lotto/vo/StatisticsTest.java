package lotto.vo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Money;
import lotto.domain.Rank;

class StatisticsTest {

    @DisplayName("등수가 몇 번 나왔는지 알 수 있다")
    @Test
    void count_frequency_of_rank() {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.FIRST, Rank.SECOND);
        Money capital = new Money(2000);
        Statistics statistics = new Statistics(ranks, capital);

        assertThat(statistics.getCountOf(Rank.FIRST)).isEqualTo(2);
        assertThat(statistics.getCountOf(Rank.SECOND)).isEqualTo(1);
        assertThat(statistics.getCountOf(Rank.THIRD)).isEqualTo(0);
    }
}