package lotto.domain;

import lotto.domain.vo.LottoTicketResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningRuleTest {

    @Test
    @DisplayName("결과에 해당하는 enumType을 찾아줘야 한다.")
    void resultEnumType() {
        // given
        LottoTicketResult result = new LottoTicketResult(6, false);

        // when
        WinningRule winningRule = WinningRule.checkWinning(result);

        // then
        assertEquals(WinningRule.FIRST, winningRule);
    }

    @Test
    @DisplayName("결과에 해당하는 enumType이 없으면 NOT_WINNER이다")
    void enumTypeHasNotResult() {
        // given
        LottoTicketResult result = new LottoTicketResult(0, false);

        // when
        WinningRule winningRule = WinningRule.checkWinning(result);

        // then
        assertEquals(WinningRule.NOT_WINNER, winningRule);
    }
}