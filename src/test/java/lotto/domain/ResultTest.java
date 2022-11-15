package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    @Test
    void 결과를_바탕으로_수익률을_계산한다() {
        Map<Ranking, Integer> result = new HashMap<>();
        result.put(Ranking.FIRST, 1);
        result.put(Ranking.SECOND, 3);
        result.put(Ranking.FOURTH, 4);
        Result r = new Result(result, new Money(200_000_000_000L));

        assertThat(r.yield()).isEqualTo(1.0);
    }
}
