package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoEvaluatorTest {
    @DisplayName("로또 번호에 범위 밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void evaluateLottos() {
        Map<WinningResult, Integer> results = new HashMap<>();
        results.put(WinningResult.FIFTH, 5); //25_000
        results.put(WinningResult.SECOND, 1); //30_000_000;
        int expected = 30_025_000;
        LottoEvaluator evaluator = new LottoEvaluator();
        assertThat(evaluator.evaluate(results)).isEqualTo(expected);
    }
}
