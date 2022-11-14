package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

public class StatisticsTest {
    private Statistics statistics;

    @BeforeEach
    void init() {
        statistics = new Statistics();
    }

    @DisplayName("기록 전, 1등부터 5등까지 모두 0으로 초기화 상태이다.")
    @ParameterizedTest
    @CsvSource(value = {
            "FIRST_PLACE, 0",
            "SECOND_PLACE, 0",
            "THIRD_PLACE, 0",
            "FOURTH_PLACE, 0",
            "FIFTH_PLACE, 0",
    })
    void isInitializedZeroCount(Rank rank, int initValue) {
        Map<Rank, Integer> rankRecord = statistics.getRankRecord();
        Assertions.assertThat(rankRecord.get(rank)).isEqualTo(initValue);
    }
}
