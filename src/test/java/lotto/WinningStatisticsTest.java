package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setWinningLotto() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        Lotto lotto = new Lotto(numbers);
        int bonusNumber = 7;
        this.winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @DisplayName("1등에 당첨되면 1등의 count가 증가한다.")
    @Test
    void createWinningStatisticsWhenFirstAward() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(winningLotto.getLotto());
        PurchasedLottos purchasedLottos = new PurchasedLottos(lottos);
        WinningStatistics winningStatistics = new WinningStatistics(purchasedLottos, winningLotto);

        assertThat(winningStatistics.getWinningStatistics().get(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("1등에 2번 당첨되면 1등의 count는 2이다.")
    @Test
    void createWinningStatisticsWhenFirstAwardTwice() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(winningLotto.getLotto());
        lottos.add(winningLotto.getLotto());
        PurchasedLottos purchasedLottos = new PurchasedLottos(lottos);
        WinningStatistics winningStatistics = new WinningStatistics(purchasedLottos, winningLotto);

        assertThat(winningStatistics.getWinningStatistics().get(Rank.FIRST)).isEqualTo(2);
    }

    @DisplayName("1000원을 지불하여 5등에 당첨이 되면 수익률은 500.0%이다.")
    @Test
    void checkProfitRateWhenFirstAward() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        Lotto lotto = new Lotto(numbers);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);
        PurchasedLottos purchasedLottos = new PurchasedLottos(lottos);
        WinningStatistics winningStatistics = new WinningStatistics(purchasedLottos, winningLotto);

        assertThat(winningStatistics.calculateProfitRate(1000)).isEqualTo(500.0f);
    }
}
