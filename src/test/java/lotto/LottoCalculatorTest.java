package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
}
