package lotto;

import lotto.domian.statistics.Statistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    List<List<Integer>> lottosNumber = Arrays.asList(List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44),
            List.of(1, 8, 11, 31, 41, 42),
            List.of(13, 14, 16, 38, 42, 45),
            List.of(7, 11, 30, 40, 42, 43),
            List.of(2, 13, 22, 32, 38, 45),
            List.of(1, 3, 5, 14, 22, 45));

    @DisplayName("발행한 로또에서 당첨된 로또의 등수 개수를 반환한다.")
    @Test
    void getEachLottoGrade() {
        // given
        Statistics statistics = new Statistics(Arrays.asList(1, 3, 5, 32, 38, 45), 7);

        // when
        Map<Integer, Integer> numberOfEachGrade = statistics.getNumberOfEachGrade(lottosNumber);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(4, 2);
        expected.put(5, 1);

        // then
        assertThat(numberOfEachGrade).isEqualTo(expected);
    }

    @DisplayName("발행한 로또의 수익률울 출력한다.")
    @Test
    void getProfit() {
        // given
        Statistics statistics = new Statistics(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // when
        double profit = statistics.getProfit(lottosNumber);

        // then
        assertThat(profit).isEqualTo((double) 62.5);
    }

}
