package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lotto.controller.LottoTicketNumberGenerator;

class LottoTicketNumberGeneratorTest {

	@Test
	void 중복된_숫자_테스트() {
		Set<Integer> lottoNums = new HashSet<>(LottoTicketNumberGenerator.generate());
		assertThat(lottoNums).hasSize(6);
	}

	@Test
	void 숫자_범위_테스트() {
		assertThat(LottoTicketNumberGenerator.generate())
			.filteredOn(num -> num >= 1 && num <= 45)
			.hasSize(6);
	}
}