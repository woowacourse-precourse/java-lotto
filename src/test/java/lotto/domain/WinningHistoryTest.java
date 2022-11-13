package lotto.domain;

import lotto.domain.vo.LottoTicketResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningHistoryTest {
    @Test
    @DisplayName("results를 주면 WinningHistory의 필드값을 생성 해야 한다.")
    void createWinningHistoryObject() {
        // given
        ArrayList<LottoTicketResult> results = new ArrayList<>();
        results.add(new LottoTicketResult(6, false));
        results.add(new LottoTicketResult(5, true));
        results.add(new LottoTicketResult(5, false));
        results.add(new LottoTicketResult(4, false));
        results.add(new LottoTicketResult(3, false));
        results.add(new LottoTicketResult(0, false));

        // when
        WinningHistory winningHistory = new WinningHistory(results);

        // then
        assertEquals(1, winningHistory.getFirstCount());
        assertEquals(1, winningHistory.getSecondCount());
        assertEquals(1, winningHistory.getThirdCount());
        assertEquals(1, winningHistory.getFourthCount());
        assertEquals(1, winningHistory.getFifthCount());
        assertEquals(2_031_555_000, winningHistory.getWinningAmount());
        assertEquals(33_859_250.0, winningHistory.getYield());
    }
}