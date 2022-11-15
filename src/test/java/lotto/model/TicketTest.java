package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketTest {
    @DisplayName("구입 금액만큼 로또가 발행됐는지 테스트")
    @Test
    void createTicket() {
        Ticket ticket = new Ticket(15000);
        assertThat(ticket.getLotteries().size()).isEqualTo(15);
    }

    @DisplayName("구입 금액이 1000원 이하이면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByLess1000() {
        assertThatThrownBy(() -> new Ticket(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByNotDivide1000() {
        assertThatThrownBy(() -> new Ticket(13500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}