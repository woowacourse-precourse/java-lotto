package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

	@DisplayName("6개의 숫자")
	@Test
	void 숫자6개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(1, 2, 3, 4, 5, 6), 7, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(6);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(0);
	}

	@DisplayName("숫자5개보너스1개")
	@Test
	void 숫자5개보너스1개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(1, 2, 3, 4, 5, 8), 6, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(5);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(1);
	}

	@DisplayName("숫자5개보너스0개")
	@Test
	void 숫자5개보너스0개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(1, 2, 3, 4, 5, 8), 7, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(5);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(0);
	}

	@DisplayName("숫자4개보너스1개")
	@Test
	void 숫자4개보너스1개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(1, 2, 3, 4, 8, 9), 5, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(4);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(1);
	}

	@DisplayName("숫자4개보너스0개")
	@Test
	void 숫자4개보너스0개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(1, 2, 3, 4, 8, 9), 7, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(4);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(0);
	}

	@DisplayName("숫자3개보너스1개")
	@Test
	void 숫자3개보너스1개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(1, 2, 3, 7, 8, 9), 4, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(3);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(1);
	}

	@DisplayName("숫자3개보너스0개")
	@Test
	void 숫자3개보너스0개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(1, 2, 3, 8, 9, 10), 7, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(3);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(0);
	}

	@DisplayName("숫자2개보너스1개")
	@Test
	void 숫자2개보너스1개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(1, 2, 7, 8, 9, 10), 3, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(2);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(1);
	}

	@DisplayName("숫자2개보너스0개")
	@Test
	void 숫자2개보너스0개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(1, 2, 8, 9, 10, 11), 7, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(2);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(0);
	}

	@DisplayName("숫자1개보너스1개")
	@Test
	void 숫자1개보너스1개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(1, 8, 9, 10, 11, 12), 2, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(1);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(1);
	}

	@DisplayName("숫자1개보너스0개")
	@Test
	void 숫자1개보너스0개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(1, 8, 9, 10, 11, 12), 7, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(1);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(0);
	}

	@DisplayName("숫자0개보너스1개")
	@Test
	void 숫자0개보너스1개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(7, 8, 9, 14, 15, 16), 1, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(0);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(1);
	}

	@DisplayName("숫자0개보너스0개")
	@Test
	void 숫자0개보너스0개() {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		Count count = new Count(List.of(11, 12, 13, 14, 15, 16), 7, lottoTickets);
		assertThat(count.getCount().get(0).get("lotto")).isEqualTo(0);
		assertThat(count.getCount().get(0).get("bonus")).isEqualTo(0);
	}
}