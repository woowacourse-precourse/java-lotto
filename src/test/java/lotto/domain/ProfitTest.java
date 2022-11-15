package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfitTest {

    private Lottos lottos;

    private WinningResult winningResult;

    private Profit profit;

    @BeforeEach
    void setUp() {

        Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        result.put(Ranking.FIRST, 6);
        result.put(Ranking.SECOND, 1);
        result.put(Ranking.THIRD, 0);
        result.put(Ranking.FOURTH, 1);
        result.put(Ranking.FIFTH, 2);
        result.put(Ranking.NOTHING, 10);

        this.lottos = new Lottos(20000);
        this.winningResult = new WinningResult(result);

        this.profit = new Profit(this.lottos, this.winningResult);
    }

    @Test
    void 수익률_계산() {
        assertThat(profit.calculateProfit(lottos, winningResult)).isEqualTo(60_150_300);
    }
}