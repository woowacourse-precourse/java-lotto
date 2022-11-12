package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto_numbers.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("8개를 구매하고, 5000원짜리 한개가 당첨되면 수익률은 62.5%이다.")
    @Test
    void rateOfReturn1() {
        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))
                )
        );

        LottoResults lottoResults = new LottoResults(
                Map.of(
                        Ranking.FIFTH, 1,
                        Ranking.FORTH, 0,
                        Ranking.THIRD, 0,
                        Ranking.SECOND, 0,
                        Ranking.FIRST, 0
                )
        );

        WinningStatistics winningStatistics = new WinningStatistics(
                purchasedLottoTickets,
                lottoResults
        );

        String statistics = winningStatistics.toString();
        assertThat(statistics).contains("62.5%");
    }

    @DisplayName("한 개도 당첨되지 않으면 수익률은 0.0%이다.")
    @Test
    void rateOfReturn2() {
        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets(
                List.of(
                        new Lotto(List.of(30, 32, 33, 34, 35, 40))
                )
        );

        LottoResults lottoResults = new LottoResults(
                Map.of(
                        Ranking.FIFTH, 0,
                        Ranking.FORTH, 0,
                        Ranking.THIRD, 0,
                        Ranking.SECOND, 0,
                        Ranking.FIRST, 0
                )
        );

        WinningStatistics winningStatistics = new WinningStatistics(
                purchasedLottoTickets,
                lottoResults
        );

        String statistics = winningStatistics.toString();
        assertThat(statistics).contains("0.0%");
    }
}