package lotto.service;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

class LottoServiceTest {

	private final LottoService lottoService = new LottoService();

	@Test
	@DisplayName("새롭게 만들어진 로또번호는 정렬된 상태")
	void makeLottoTest() {
		Lotto lotto = lottoService.makeLotto();
		List<Integer> lottoNumbers = lotto.getNumbers();

		Collections.sort(lottoNumbers);
		Assertions.assertThat(lottoNumbers).isEqualTo(lotto.getNumbers());
	}
}
