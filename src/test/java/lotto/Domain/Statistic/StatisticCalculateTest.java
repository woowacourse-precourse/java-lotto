package lotto.Domain.Statistic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticCalculateTest {
    @DisplayName("일치하는 보너스가 없으면 0을 리턴하는가")
    @Test
    void hasNoBonusReturnZero() {
        List<Integer> compare = List.of(1, 2, 3, 4, 5, 6);
        Set<Integer> published = new HashSet<>(compare);
        int bonus = 9;

        assertThat(new StatisticCalculate().hasBonusSize(published, compare, bonus))
                .isEqualTo(0);
    }
    @DisplayName("일치하는 보너스가 있으면 0을 리턴하는가")
    @Test
    void hasBonusReturnZero() {
        List<Integer> compare = List.of(1, 2, 3, 4, 5, 6);
        Set<Integer> published = new HashSet<>(compare);
        int bonus = 6;

        assertThat(new StatisticCalculate().hasNoBonusSize(published, compare, bonus))
                .isEqualTo(0);
    }
}
