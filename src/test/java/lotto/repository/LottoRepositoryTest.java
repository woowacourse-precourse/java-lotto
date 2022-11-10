package lotto.repository;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

public class LottoRepositoryTest {

	private final LottoRepository lottoRepository = new LottoRepository();

	@DisplayName("로또 숫자들이 중복되지 않는지 검사")
	@Test
	void givenNone_whenMakeAutoLotto_thenReturnLottoNumbers(){
	    //given

	    //when
		Lotto lotto = lottoRepository.makeAutoLotto();
		Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());

		//then
		Assertions.assertThat(lottoNumbers.size())
			.isEqualTo(6);
	}

}
