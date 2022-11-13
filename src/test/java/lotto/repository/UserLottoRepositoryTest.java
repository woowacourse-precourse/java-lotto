package lotto.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.repository.dto.UserLottoDto;

class UserLottoRepositoryTest {

	private UserLottoRepository userLottoRepository;

	@BeforeEach
	void setUp() {
		userLottoRepository = new UserLottoRepository();
	}

	@AfterEach
	void tearDown() {
		userLottoRepository.clear();
	}

	@DisplayName("사용자 로또 번호 저장 및 확인 테스트")
	@Test
	void updateLottoTest() {
		//given
		Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		//when
		userLottoRepository.updateLotto(lotto1);
		userLottoRepository.updateLotto(lotto2);
		UserLottoDto userLottoDto = userLottoRepository.findUserLottoDto();

		//then
		Assertions.assertThat(userLottoDto.getUserLotto()).contains(lotto1, lotto2);
	}

}
