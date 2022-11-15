package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoTicketingTest {
    @DisplayName("구입하는 로또의 개수가 입력값과 일치한다")
    @Nested
    class GetLottoTicketsTest{
        @Test
        void case1() {
            int TicketNumber = 8;
            LottoTicketing lottoTicketing = new LottoTicketing(TicketNumber);
            assertEquals(lottoTicketing.getLottoTickets().size(), TicketNumber);
        }

        @Test
        void case2() {
            int TicketNumber = 1;
            LottoTicketing lottoTicketing = new LottoTicketing(TicketNumber);
            assertEquals(lottoTicketing.getLottoTickets().size(), TicketNumber);
        }
    }

}
