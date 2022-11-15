package lotto.controller;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TicketMachineTest {

    @DisplayName("구입한 금액만큼의 티켓을 주어진 룰에 따라 발행")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void issueTickets(int ticketNumber) {
        assertThat(TicketMachine.issueTickets(ticketNumber).size()).isEqualTo(ticketNumber);
        for (List<Integer> ticket : TicketMachine.issueTickets(ticketNumber)) {
            assertThat(ticket.stream().distinct().count() == ticket.size()).isTrue();
        }
    }
}
