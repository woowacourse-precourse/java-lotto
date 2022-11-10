package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

	@Test
	void 중복된_숫자_테스트() {
		Set<Integer> lottoNums = new HashSet<>(LottoNumberGenerator.generate());
		assertThat(lottoNums).hasSize(6);

	}

	@Test
	void 숫자_범위_테스트() {
		assertThat(LottoNumberGenerator.generate())
			.filteredOn(num -> num >= 1 && num <= 45)
			.hasSize(6);
	}
}