package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    private Statistics statistics;

    @BeforeEach
    void init() {
        statistics = new Statistics();
    }

    @ParameterizedTest(name = "기록 전, 1등부터 5등까지 모두 0으로 초기화 상태이다. (로또 등수 : {0}, 등수 별 카운트 : {1})")
    @CsvSource(value = {
            "FIRST_PLACE, 0",
            "SECOND_PLACE, 0",
            "THIRD_PLACE, 0",
            "FOURTH_PLACE, 0",
            "FIFTH_PLACE, 0"
    })
    void isInitializedZeroCount(Rank rank, int initValue) {
        Map<Rank, Integer> rankRecord = statistics.getRankRecord();
        assertThat(rankRecord.get(rank)).isEqualTo(initValue);
    }

    @ParameterizedTest(name = "각 등수 별로 한 번씩 당첨됐을 때 기록 상황 확인 (로또 등수 : {0}, 등수 별 카운트 : {1})")
    @CsvSource(value = {
            "FIRST_PLACE, 1",
            "SECOND_PLACE, 1",
            "THIRD_PLACE, 1",
            "FOURTH_PLACE, 1",
            "FIFTH_PLACE, 1"
    })
    void record(Rank rank, int count) {
        statistics.record(rank);
        Map<Rank, Integer> rankRecord = statistics.getRankRecord();
        assertThat(rankRecord.get(rank)).isEqualTo(count);
    }
}
