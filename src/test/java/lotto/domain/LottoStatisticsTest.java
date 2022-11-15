package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoStatisticsTest {
    private static final String LINE_FEED = "\n";

    @DisplayName("수익률 테스트")
    @Test
    void getYieldTest() {
        List<Lotto> lottoTickets = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(45, 44, 43, 4, 5, 6)));
        LottoGame lottoGame = new LottoGame(new Lotto(List.of(1, 2, 3, 45, 44, 43)), 7, lottoTickets);

        LottoStatistics lottoStatistics = lottoGame.checkMatchLotto();
        assertEquals("3개 일치 (5,000원) - " + 2 + "개" + LINE_FEED +
                "4개 일치 (50,000원) - " + 0 + "개" + LINE_FEED +
                "5개 일치 (1,500,000원) - " + 0 + "개" + LINE_FEED +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + 0 + "개" + LINE_FEED +
                "6개 일치 (2,000,000,000원) - " + 0 + "개", lottoStatistics.toString());

        assertEquals("500.0", lottoStatistics.getYield());
    }

}