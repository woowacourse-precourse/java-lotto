package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.model.Statistics;

class StatisticsTest {
    Statistics statistics;

    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach");
        statistics = new Statistics();
    }

    @Test
    @DisplayName("1등당첨 한개를 얻을 수 있는지")
    void checkPrizeQuantity_own_One_PRIZE1() {
        Map<String, Integer> prizeBundle = statistics.checkPrizeQuantity(List.of(1, 2, 3, 4, 5, 6),
            7, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        Map<String, Integer> answer = Map.of(
            "PRIZE1", 1,
            "PRIZE2", 0,
            "PRIZE3", 0,
            "PRIZE4", 0,
            "PRIZE5", 0
        );

        assertThat(prizeBundle).isEqualTo(answer);
    }

    @Test
    @DisplayName("2등당첨 한개를 얻을 수 있는지")
    void checkPrizeQuantity_own_One_PRIZE2() {
        Map<String, Integer> prizeBundle = statistics.checkPrizeQuantity(List.of(1, 2, 3, 4, 5, 6),
            7, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))));
        Map<String, Integer> answer = Map.of(
            "PRIZE1", 0,
            "PRIZE2", 1,
            "PRIZE3", 0,
            "PRIZE4", 0,
            "PRIZE5", 0
        );
        assertThat(prizeBundle).isEqualTo(answer);
    }
}
