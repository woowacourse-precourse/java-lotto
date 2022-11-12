package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TicketTest {
    private Ticket ticket;

    @BeforeEach
    public void setup() {
        int money = 1000;
        ticket = Ticket.purchase(money);
    }

    @DisplayName("로또 구매하는 기능 테스트입니다.")
    @Test
    public void purchaseTicket() {
        assertThat(ticket).isInstanceOf(Ticket.class);
    }
}