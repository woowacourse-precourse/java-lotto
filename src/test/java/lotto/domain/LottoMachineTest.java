package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
	@DisplayName("LottoTickets의 size가 입력값과 같다")
	@Nested
	class GetLottoTicketsTest {
		@Test
		void case1() {
			int numberOfTickets = 8;
			LottoMachine lottoMachine = new LottoMachine(numberOfTickets);
			assertEquals(lottoMachine.getLottoTickets().size(), numberOfTickets);
		}

		@Test
		void case2() {
			int numberOfTickets = 1;
			LottoMachine lottoMachine = new LottoMachine(numberOfTickets);
			assertEquals(lottoMachine.getLottoTickets().size(), numberOfTickets);
		}

		@Test
		void case3() {
			int numberOfTickets = 7;
			LottoMachine lottoMachine = new LottoMachine(numberOfTickets);
			assertEquals(lottoMachine.getLottoTickets().size(), numberOfTickets);
		}

	}
}
