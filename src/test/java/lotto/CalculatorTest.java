package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

class CalculatorTest {

    @Test
    void 정상_작동() {
        // given
        List<Lotto> lottos = List.of(
                Lotto.numberOf(List.of(1, 2, 3, 4, 5, 6)), // 6
                Lotto.numberOf(List.of(1, 2, 3, 4, 5, 7)), // 5 + a
                Lotto.numberOf(List.of(1, 2, 3, 4, 5, 8)), // 5
                Lotto.numberOf(List.of(1, 2, 3, 4, 8, 9)), // 4
                Lotto.numberOf(List.of(1, 2, 3, 8, 9, 10)) // 3
        );
        Lotto answerLotto = Lotto.numberOf(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;

        // when
        HashMap<Hit, Integer> result = Calculator.getLottoResult(lottos, answerLotto, bonusNumber);

        // then
        for (Hit hit : result.keySet()) {
            Assertions.assertThat(result.get(hit)).isEqualTo(1);
        }
    }
}