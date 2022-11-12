package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TicketTest {
    @DisplayName("로또 구매하는 기능 테스트입니다.")
    @Test
    public void test() throws Exception {
        int money = 1000;

        assertThat(Ticket.purchase(money)).isInstanceOf(Ticket.class);
    }
}