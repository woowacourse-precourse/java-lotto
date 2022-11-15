package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EarningsRateTest {
	Map<LottoType, Integer> stat;
	List<LottoTicket> lottoTickets;

	@BeforeEach
	void beforeEach() {
		stat = new HashMap<>();
		lottoTickets = new ArrayList<>();
		stat.put(LottoType.FIRST, 1);
		stat.put(LottoType.SECOND, 1);
		stat.put(LottoType.THIRD, 1);
		stat.put(LottoType.FOURTH, 1);
		stat.put(LottoType.FIFTH, 1);
		stat.put(LottoType.FAIL, 1);
		for (int i = 0; i < 50; i++) {
			lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
		}
	}

	@Test
	void getEarningsRate() {
		EarningsRate earningsRate = new EarningsRate(stat, lottoTickets);
		assertThat(earningsRate.getEarningsRate()).isEqualTo(new BigDecimal("40631.1"));
	}
}
