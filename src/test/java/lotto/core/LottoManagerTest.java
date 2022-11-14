package lotto.core;

import lotto.models.Lotto;
import lotto.models.Rank;
import lotto.models.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {

	@DisplayName("사용자가 1~5등을 1번씩만 당첨됐다고 할 때, 그 횟수 카운팅을 잘 했는지 확인하는 테스트")
	@Test
	void checkUserLotteriesCountingTest() {
		/*
		===== given =====
		당첨로또 번호 : 1,2,3,4,5,6 + 보너스 7

		[ 사용자가 고른 로또 번호 ]
		12, 13, 14, 15, 16, 17 => 순위권 밖
		11, 13, 4, 5, 6, 7 => 5등
		12, 3, 4, 5, 6, 7 => 4등
		2, 3, 4, 5, 6, 37 => 3등
		2, 3, 4, 5, 6, 7 => 2등
		1, 2, 3, 4, 5, 6 => 1등
		사용자가 구매한 로또가 각각 1~5등을 1번씩하는 형태로 구매된다고 가정
		 */
		final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		final WinningLotto winningLotto = new WinningLotto(lotto, 7);
		final List<Lotto> userLotteries = List.of(
				new Lotto(List.of(12, 13, 14, 15, 16, 17)), // NONE
				new Lotto(List.of(11, 13, 4, 5, 6, 7)), // 5등
				new Lotto(List.of(12, 3, 4, 5, 6, 7)), // 4등
				new Lotto(List.of(2, 3, 4, 5, 6, 37)), // 3등
				new Lotto(List.of(2, 3, 4, 5, 6, 7)), // 2등
				new Lotto(List.of(1, 2, 3, 4, 5, 6)) // 1등
		);

		// when : Lotto manager 는 사용자가 구매한 로또들을 당첨로또와 비교하여 각 등수의 횟수를 구할 때
		LottoManager manager = new LottoManager(winningLotto, userLotteries);
		Map<Rank, Long> result = manager.countResultRankFromUserLotteries();

		// then : 모든 등수에 대해 각각 1번의 횟수를 카운팅 했는지 확인한다.
		final Map<Rank, Long> expected = new HashMap<>() {{
			put(Rank.FIRST, 1L);
			put(Rank.SECOND, 1L);
			put(Rank.THIRD, 1L);
			put(Rank.FOURTH, 1L);
			put(Rank.FIFTH, 1L);
		}};
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("사용자의 로또 번호들이 모두 순위권 밖일 때, 매칭되는 등수가 없어야 한다.")
	@Test
	void checkUserLotteriesAllOutOfRankedTest() {
		/*
		===== given =====
		당첨로또 번호 : 1,2,3,4,5,6 + 보너스 7

		[ 사용자가 고른 로또 번호 ]
		12, 13, 14, 15, 16, 17 => 순위권 밖 : 다 다름
		1, 13, 44, 35, 26, 27 => 순위권 밖 : 1만 같음
		3, 5, 43, 45, 26, 37 => 순위권 밖 : 3, 5만 같음
		7, 6, 3, 10, 9, 40 => 순위권 밖 : 3, 6만 같음
		사용자가 구매한 로또가 모두 순위권 밖이라고 가정
		 */
		final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		final WinningLotto winningLotto = new WinningLotto(lotto, 7);
		final List<Lotto> userLotteries = List.of(
				new Lotto(List.of(12, 13, 14, 15, 16, 17)), // NONE
				new Lotto(List.of(1, 13, 44, 35, 26, 27)), // NONE
				new Lotto(List.of(3, 5, 43, 45, 26, 37)), // NONE
				new Lotto(List.of(7, 6, 3, 10, 9, 40)) // NONE
		);

		// when : Lotto manager 는 사용자가 구매한 로또들을 당첨로또와 비교하여 각 등수의 횟수를 구할 때
		LottoManager manager = new LottoManager(winningLotto, userLotteries);
		Map<Rank, Long> result = manager.countResultRankFromUserLotteries();

		// then : 매칭되는 등수가 아예 없어야 한다.
		final Map<Rank, Long> expected = new HashMap<>();
		assertThat(result).isEqualTo(expected);
	}
}