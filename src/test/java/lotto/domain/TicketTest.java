package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TicketTest {
    private Ticket ticket;

    @BeforeEach
    public void setup() {
        int money = 1000;
        ticket = Ticket.purchase(money);
    }

    @DisplayName("정상적으로 로또를 구매한다.")
    @Test
    public void purchaseTicket() {
        assertThat(ticket).isInstanceOf(Ticket.class);
    }

    @DisplayName("구매한 로또 중 해당 순서의 발행된 로또를 가져온다.")
    @Test
    public void getLottoByIndex() {
        Lotto firstLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(Arrays.asList(1, 2, 3, 30, 42, 45));
        ticket = new Ticket(Arrays.asList(firstLotto, secondLotto));

        assertThat(ticket.get(0)).isEqualTo(firstLotto);
        assertThat(ticket.get(1)).isEqualTo(secondLotto);
    }

    @DisplayName("구매한 로또의 개수를 가져온다.")
    @Test
    public void getTicketCount() {
        Lotto firstLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(Arrays.asList(1, 2, 3, 30, 42, 45));
        List<Lotto> tickets = Arrays.asList(firstLotto, secondLotto);
        int count = tickets.size();

        ticket = new Ticket(count, tickets);

        assertThat(ticket.size()).isEqualTo(2);
    }
}