package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTicketTest {
    private WinningLottoTicket winningLottoTicket;

    @BeforeEach
    void setWinningLottoTickets() {
        winningLottoTicket = new WinningLottoTicket();
    }

    @Test
    void countWinningLotto_테스트() {
        WinningLotto winningLotto = WinningLotto.FIFTH;
        winningLottoTicket.countWinningLotto(winningLotto);
        winningLottoTicket.countWinningLotto(WinningLotto.NOTHING);
        assertThat(winningLottoTicket.getWinningLottoCount().get(winningLotto)).isEqualTo(1);
    }

}
