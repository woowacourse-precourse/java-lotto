package lotto.domain.model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

	@Test
	void 제대로_작동(){
		List<List<Integer>> tickets = new ArrayList<>();
		tickets.add(Arrays.asList(45, 2, 3, 4, 5, 6));
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 7));
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket lottoTicket = new LottoTicket(tickets);

		assertEquals(tickets, lottoTicket.getLottoTicket());
	}

	@Test
	void 티켓이_6개가_아닐_때(){
		List<List<Integer>> tickets = new ArrayList<>();
		tickets.add(Arrays.asList(45, 2, 3, 4, 5, 6));
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 8, 7));
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));

		assertThatThrownBy(() -> new LottoTicket(tickets))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 티켓이_6개가_아닐_때2(){
		List<List<Integer>> tickets = new ArrayList<>();
		tickets.add(Arrays.asList(45, 2, 3, 4, 5, 6));
		tickets.add(Arrays.asList(1));
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));

		assertThatThrownBy(() -> new LottoTicket(tickets))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
