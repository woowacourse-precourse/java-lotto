package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {
	WinningNumber winningNumber;
	List<Lotto> lottos = new LinkedList<>();

	@BeforeEach
	void init() {
		Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = new BonusNumber(7);
		winningNumber = new WinningNumber(winningLotto, bonusNumber);

		lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
		lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
		lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
		lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
		lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
		lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
		lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
		lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
	}

	@DisplayName("구매한 로또 당첨 내역 확인 테스트")
	@Test
	void 로또_당첨_내역_테스트() {
	    //given
		LottoStatistics lottoStatistics = new LottoStatistics(winningNumber);
	    //when
		Map<LottoRanking, Integer> result = lottoStatistics.getWinningResult(lottos);
		//then
		assertThat(result.keySet()).contains(LottoRanking.FIFTH, LottoRanking.BLANK);
	}

	@DisplayName("구매한 로또의 수익률 확인 테스트")
	@Test
	void 로또_수익률_확인_테스트() {
		//given
		LottoStatistics lottoStatistics = new LottoStatistics(winningNumber);
		//when
		Double yield = lottoStatistics.calculateYield(lottos, lottoStatistics.getWinningResult(lottos));
		//then
		assertThat(yield).isEqualTo(62.5);
	}
}
