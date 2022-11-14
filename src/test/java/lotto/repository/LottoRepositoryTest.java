package lotto.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

public class LottoRepositoryTest {

	private final LottoRepository lottoRepository = LottoRepository.getInstance();

	@DisplayName("로또 숫자들이 중복되지 않는지 검사")
	@Test
	void givenNone_whenMakeAutoLotto_thenReturnLottoNumbers() {
		//given

		//when
		Lotto lotto = lottoRepository.makeAutoLotto();
		Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());

		//then
		Assertions.assertThat(lottoNumbers.size())
			.isEqualTo(6);
	}

	@DisplayName("당첨 로또가 정상적으로 생성되는지 생성")
	@Test
	void givenLottoWinningNumber_whenMakeWinnerLotto_thenInputLottoNumberEqualsWInnerLotto() {
		//given
		String inputLottoWinningNumber = "1,2,3,4,5,6";

		//when
		List<Integer> winnerLotto = lottoRepository.makeWinnerLotto(inputLottoWinningNumber);

		//then
		Assertions.assertThat(winnerLotto.containsAll(List.of(1, 2, 3, 4, 5, 6)))
			.isTrue();
	}

}
