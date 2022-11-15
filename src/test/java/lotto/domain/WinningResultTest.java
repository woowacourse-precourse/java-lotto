package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    @Test
    @DisplayName("상금합이 정상적으로 계산된다.")
    public void calculate() {
        // given
        List<Ranking> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(Ranking.FIFTH);
        lottoNumbersList.add(Ranking.FIFTH);
        lottoNumbersList.add(Ranking.FOURTH);

        // when

        // then
        int expect = Ranking.FIFTH.getPrize() * 2 + Ranking.FOURTH.getPrize();
        WinningResult winningResult = new WinningResult(lottoNumbersList);
        assertThat(winningResult.calculatePrizeSum()).isEqualTo(expect);
    }
}