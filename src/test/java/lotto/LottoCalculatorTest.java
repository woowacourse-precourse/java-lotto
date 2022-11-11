package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {
    @DisplayName("로또 등수를 계산한다. 5개 번호 + 보너스 번호가 일치하면 2등이다.")
    @Test
    void calculateRank() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonusNumber = new Bonus(7);
        Lotto lottoTicket = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        int rank = LottoCalculator.calculateRank(winningNumber, bonusNumber, lottoTicket);

        assertThat(rank).isEqualTo(2);
    }
}
