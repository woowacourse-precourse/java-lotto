package lotto;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class WinningStatisticsTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setWinningLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        this.winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @DisplayName("당첨 통계 생성 성공")
    @Test
    void createWinningStatisticsSuccess() {
        List<Lotto> lottos = List.of(winningLotto.getLotto());
        PurchasedLottos purchasedLottos = new PurchasedLottos(lottos);

        assertThatCode(() -> new WinningStatistics(purchasedLottos, winningLotto))
                .doesNotThrowAnyException();
    }

    @DisplayName("1등에 당첨되면 1등의 count가 증가한다.")
    @Test
    void createWinningStatisticsWhenFirstAward() {
        List<Lotto> lottos = List.of(winningLotto.getLotto());
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

    @DisplayName("올바른 당첨 현황을 보여주는지 확인")
    @Test
    void checkValidWinningStatistics() {
        Lotto firstAwardLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondAwardLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdAwardLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto forthAwardLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto fifthAwardLotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        Lotto missedAwardLotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));

        PurchasedLottos purchasedLottos = new PurchasedLottos(
                List.of(firstAwardLotto, secondAwardLotto,
                        thirdAwardLotto, forthAwardLotto,
                        fifthAwardLotto, missedAwardLotto)
        );

        WinningStatistics winningStatistics = new WinningStatistics(purchasedLottos, winningLotto);

        assertThat(winningStatistics.getWinningStatistics())
                .isEqualTo(Map.of(
                        Rank.FIRST, 1,
                        Rank.SECOND, 1,
                        Rank.THIRD, 1,
                        Rank.FORTH, 1,
                        Rank.FIFTH, 1,
                        Rank.MISS, 1
                ));
    }

    @DisplayName("1000원을 지불하여 5등에 당첨이 되면 수익률은 500.0%이다.")
    @Test
    void checkProfitRateWhenFirstAward() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        PurchasedLottos purchasedLottos = new PurchasedLottos(List.of(lotto));
        WinningStatistics winningStatistics = new WinningStatistics(purchasedLottos, winningLotto);

        assertThat(winningStatistics.calculateProfitRate(1000)).isEqualTo(500.0f);
    }
}
