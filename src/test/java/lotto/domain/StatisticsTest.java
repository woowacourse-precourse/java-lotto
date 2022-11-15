package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class StatisticsTest {
    private Statistics statistics;

    @BeforeEach
    void init() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        this.statistics = new Statistics(lotto, 10);
    }

    @Test
    @DisplayName("생성자 테스트_보너스 숫자 중복")
    void constructor_test_overlapped() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new Statistics(lotto, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성자 테스트_정상 입력")
    void constructor_test() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> new Statistics(lotto, 10));
    }

    @Test
    @DisplayName("통계 결과 반환 테스트")
    void statistics_test() {
        List<Lotto> purchased = new ArrayList<>();
        purchased.add(new Lotto(List.of(1, 2, 3, 10, 11, 12)));
        purchased.add(new Lotto(List.of(1, 2, 3, 4, 5, 10)));


        Map<Rank, Integer> result = statistics.getResult(purchased);

        assertThat(result.get(Rank.FIRST)).isEqualTo(0);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD)).isEqualTo(0);
        assertThat(result.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(result.get(Rank.FIFTH)).isEqualTo(1);
    }

}