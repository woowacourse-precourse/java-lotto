package lotto;

import lotto.model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketTest {
    @DisplayName("로또 티켓 생성 확인.")
    @Test
    void createLottoTickets() {
        LottoTicket lottoTicket = new LottoTicket(3);
        assertThat(lottoTicket.getLottoTickets().size()).isEqualTo(3);
    }
}
