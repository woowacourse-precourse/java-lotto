package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Lotto;
import lotto.system.holder.ValidationHolder;
import lotto.system.validator.Validator;
import lotto.vo.LottoAmount;

class LottoServiceTest {
	private final LottoService lottoService = new LottoService();

	@BeforeEach
	void setup() {
		ValidationHolder.initializeValidators(List.of(getMockValidator()));
	}

	@AfterEach
	void runAfter() {
		ValidationHolder.clearHolder();
	}

	@Test
	@DisplayName("주어진 LottoAmount 값만큼 새로운 Lotto 객체를 만들어 반환한다.")
	void givenLottoAmount_whenCreatingLotto_thenReturnsListOfLotto() {
		//given
		LottoAmount lottoAmount = LottoAmount.of(10);

		//when
		List<Lotto> result = lottoService.createLottos(lottoAmount);

		//then
		assertThat(result).hasSize(10);
	}

	private static Validator getMockValidator() {
		return new Validator() {
			@Override
			public boolean supports(Object target, Class<?> to) {
				return true;
			}

			@Override
			public void validate(Object target) {
			}
		};
	}
}