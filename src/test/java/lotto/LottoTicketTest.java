package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTicketTest {

    @Test
    void 천원에_한_장() {
        long pay = 30000;
        long ticket = LottoTicket.LottoTicket(pay);
        assertThat(ticket).isEqualTo(30);
    }
}