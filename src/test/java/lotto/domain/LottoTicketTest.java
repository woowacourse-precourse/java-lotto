package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
	@DisplayName("구매 갯수만큼 티켓이 발행되는지")
	@Test
	void createLottoTickets() {
		int userMoney = 10000;
		LottoTicket lottoTicket = new LottoTicket(userMoney);

		List<List<Integer>> lottoTickets = lottoTicket.createLottoTickets();

		assertEquals(lottoTickets.size(), 10);
	}
}
