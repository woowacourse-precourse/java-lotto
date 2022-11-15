package lotto.service;

import static lotto.domain.LottoRankStatus.*;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.LottoRankStatus;
import lotto.domain.WinningLotto;

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

	@Test
	@DisplayName("로또 숫자 리스트에 맞는 순위 반환")
	void determineLottoRankStatusTest() {
		WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), List.of(7));
		Lotto firstRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto secondRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
		Lotto thirdRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
		Lotto fourthRankLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
		Lotto fifthRankLotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
		Lotto outOfRankLotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));

		LottoRankStatus firstRank = lottoService.determineLottoRankStatus(firstRankLotto, winningLotto);
		LottoRankStatus secondRank = lottoService.determineLottoRankStatus(secondRankLotto, winningLotto);
		LottoRankStatus thirdRank = lottoService.determineLottoRankStatus(thirdRankLotto, winningLotto);
		LottoRankStatus fourthRank = lottoService.determineLottoRankStatus(fourthRankLotto, winningLotto);
		LottoRankStatus fifthRank = lottoService.determineLottoRankStatus(fifthRankLotto, winningLotto);
		LottoRankStatus outOfRank = lottoService.determineLottoRankStatus(outOfRankLotto, winningLotto);

		Assertions.assertThat(firstRank).isEqualTo(FIRST_RANK);
		Assertions.assertThat(secondRank).isEqualTo(SECOND_RANK);
		Assertions.assertThat(thirdRank).isEqualTo(THIRD_RANK);
		Assertions.assertThat(fourthRank).isEqualTo(FOURTH_RANK);
		Assertions.assertThat(fifthRank).isEqualTo(FIFTH_RANK);
		Assertions.assertThat(outOfRank).isEqualTo(OUT_OF_RANK);
	}
}
