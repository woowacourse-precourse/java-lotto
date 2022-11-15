package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {
    @DisplayName("로또 등수를 계산한다. 5개 번호 + 보너스 번호가 일치하면 2등이다.")
    @Test
    void calculateRank() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        Optional<Rank> rank = LottoCalculator.calculateRank(winningNumbers, bonus, ticket);

        assertThat(rank.orElseThrow()).isEqualTo(Rank.SECONDS);
    }

    @DisplayName("수익률을 계산한다. 8000원의 구입 금액으로 5등 하나 당첨이면 수익률은 62.5%다.")
    @Test
    void rateOfReturn() {
        Map<Rank, Integer> winningHistory = new LinkedHashMap<>();
        winningHistory.put(Rank.FIFTH, 1);
        Money purchasePrice = new Money(8000);

        double rateOfReturn = LottoCalculator.getRateOfReturn(winningHistory, purchasePrice);

        assertThat(rateOfReturn).isEqualTo(62.5);
    }
}
