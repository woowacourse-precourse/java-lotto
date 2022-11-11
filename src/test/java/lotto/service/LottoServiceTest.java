package lotto.service;

import lotto.vo.Lotto;
import lotto.system.LottoApplication;
import lotto.vo.LottoAmount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
	private final LottoService lottoService = new LottoService();

	@BeforeEach
	void setup() {
		LottoApplication.initializeValidators();
		LottoApplication.initializeConverters();
	}

	@AfterEach
	void runAfter() {
		LottoApplication.doAfter();
	}

	@Test
	@DisplayName("주어진 LottoAmount 값만큼 새로운 Lotto 객체를 만들어 반환한다.")
	void givenLottoAmount_whenCreatingLotto_thenReturnsListOfLotto() {
		//given
		LottoAmount lottoAmount = new LottoAmount(10);

		//when
		List<Lotto> result = lottoService.createLottos(lottoAmount);

		//then
		assertThat(result).hasSize(10);
	}
}