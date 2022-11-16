package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
	@DisplayName("구매 갯수만큼 티켓이 발행되는지")
	@Test
	void createLottoTickets() {
		int ticketCount = 10;
		LottoTicket lottoTicket = new LottoTicket(ticketCount);

		List<Lotto> lottoTickets = lottoTicket.getLottoTickets();

		assertEquals(lottoTickets.size(), 10);
	}
}
