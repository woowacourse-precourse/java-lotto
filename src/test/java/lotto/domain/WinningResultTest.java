package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);
        winningResult.put(Ranking.FIRST, 6);
        winningResult.put(Ranking.SECOND, 1);
        winningResult.put(Ranking.THIRD, 0);
        winningResult.put(Ranking.FOURTH, 1);
        winningResult.put(Ranking.FIFTH, 2);
        winningResult.put(Ranking.NOTHING, 10);
        this.winningResult = new WinningResult(winningResult);
    }

    @Test
    void 총_상금_계산() {
        assertThat(winningResult.calculateTotalPrize()).isEqualTo(5_000 * 2 + 50_000 + 30_000_000 + 2_000_000_000L * 6);
    }
}
