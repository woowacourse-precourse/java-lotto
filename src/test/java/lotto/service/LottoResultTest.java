package lotto.service;

import lotto.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    private Map<Prize, Integer> statistics;

    @BeforeEach
    void init() {
        List<Lotto> lotteries = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        Ticket ticket = new Ticket(lotteries, 10000);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), new BonusNumber(45));
        this.statistics = LottoResultService.getStatistics(ticket, winningLotto);
    }

    @DisplayName("당첨 내역이 일치하는지 테스트")
    @Test
    void checkLottoResult() {
        assertThat(statistics.get(Prize.FIRST)).isEqualTo(2);
        assertThat(statistics.get(Prize.SECOND)).isEqualTo(1);
        assertThat(statistics.get(Prize.THIRD)).isEqualTo(1);
        assertThat(statistics.get(Prize.FOURTH)).isEqualTo(1);
        assertThat(statistics.get(Prize.FIFTH)).isEqualTo(1);
    }

    @DisplayName("총 상금이 당첨 내역 상금의 합계와 같은지 테스트")
    @Test
    void checkLottoResultPrizeMoney() {
        double prizeMoney = LottoResultService.getPrizeMoney(statistics);
        assertThat(prizeMoney).isEqualTo(4031555000L);
    }
}