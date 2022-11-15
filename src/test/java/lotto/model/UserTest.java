package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    private User user;
    private int ticketCount = 3;
    private int TICKET_LENGTH = 6;
    private int NUMBER_MIN = 1;
    private int NUMBER_MAX = 45;

    @BeforeEach
    void setup() {
        user = new User(ticketCount);
        user.setTickets();
    }

    @DisplayName("티켓 구매 갯수대로 로또 티켓이 발행되는지 확인한다.")
    @Test
    void validateTicketCount() {
        List<List<Integer>> tickets = user.getTickets();

        assertThat(tickets.size()).isEqualTo(ticketCount);
    }

    @DisplayName("발행한 티켓이 6자리인지 확인한다.")
    @Test
    void validateTicketLength() {
        List<List<Integer>> tickets = user.getTickets();

        assertThat(tickets)
                .allMatch(ticketTmp -> ticketTmp.size() == TICKET_LENGTH);
    }

    @DisplayName("로또 티켓의 숫자가 범위(1~45)에 속하는지 확인한다.")
    @Test
    void createLottoTickets() {
        List<List<Integer>> tickets = user.getTickets();
        List<Integer> ticket = tickets.get(0);

        assertThat(ticket)
                .allMatch(number -> number >= NUMBER_MIN &&  number <= NUMBER_MAX);
    }
}