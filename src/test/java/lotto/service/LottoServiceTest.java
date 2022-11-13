package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.repository.UserLottoRepository;
import lotto.repository.dto.UserLottoDto;

class LottoServiceTest {

	private UserLottoRepository userLottoRepository;
	private LottoService lottoService;

	@BeforeEach
	void setUp() {
		userLottoRepository = new UserLottoRepository();
		lottoService = new LottoService(userLottoRepository);
	}

	@DisplayName("사용자가 구매한 로또 개수만큼 로또를 만들어서 userLottoRepository 에 저장 확인 테스트")
	@Test
	public void makeRandomLottoNumberTest() {
		//given
		UserLottoDto userLottoDto = lottoService.makeRandomLottoNumber(3);

		//when
		UserLottoDto userLottoDtoTest = userLottoRepository.findUserLottoDto();

		//then
		Assertions.assertThat(userLottoDto.getUserLotto()).isEqualTo(userLottoDtoTest.getUserLotto());
	}

}
