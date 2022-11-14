package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @DisplayName("모든 결과들을 종합하여 각 등수에 해당하는 로또 개수가 통계에 잘 저장되는지 테스트")
    @Test
    void generateStatistics() {
        //given
        Result result1 = generateResult(6, false);
        Result result2 = generateResult(6, false);
        Result result3 = generateResult(5, true);

        Results results = new Results();
        results.addResult(result1);
        results.addResult(result2);
        results.addResult(result3);
        //when
        Statistics statistics = results.generateStatistics();
        //then
        Assertions.assertThat(statistics.getStatisticsResult()
                                        .get(Prize.FIRST))
                  .isEqualTo(2);
        Assertions.assertThat(statistics.getStatisticsResult()
                                        .get(Prize.SECOND))
                  .isEqualTo(1);
    }

    Result generateResult(int number, boolean isBonus) {
        Result result = new Result();
        for (int i = 0; i < number; i++) {
            result.increaseMatchCount();
        }
        if (isBonus) {
            result.matchBonus();
        }
        return result;
    }
}