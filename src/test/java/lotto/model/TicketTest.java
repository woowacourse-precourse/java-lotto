package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {
    @DisplayName("구입 금액만큼 로또가 발행됐는지 테스트")
    @Test
    void createTicket() {
        Ticket ticket = new Ticket(15000);
        assertThat(ticket.getLotteries().size()).isEqualTo(15);
    }
}