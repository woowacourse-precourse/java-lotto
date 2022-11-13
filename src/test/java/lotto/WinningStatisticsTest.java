package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Publisher;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    @DisplayName("당첨 로또를 생성합니다.")
    @Test
    void countWinningLottosTest() {
        Publisher lottoPublisher = new Publisher(1000);
        WinningLotto winningLotto = new WinningLotto(lottoPublisher.getLottos().get(0).getNumbers(), 7);
        WinningStatistics lottoStatistics = new WinningStatistics(lottoPublisher, winningLotto);
        assertThat(lottoStatistics.getNumberOfWinningLottos()).contains(0,0,0,0,1);
    }
}
