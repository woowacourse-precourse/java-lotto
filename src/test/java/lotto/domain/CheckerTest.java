package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CheckerTest {
	@Nested
	@DisplayName("로또 당첨 게임의 개수를 구하는 기능 테스트")
	class getTotalWinsTest {
		@Test
		@DisplayName("4등과 5등이 당첨되었을때 FORTH, FIFTH의 count에 각각 1씩 추가한다.")
		void getTotalWinsTest1() {
			int bonusNumber = 17;
			String winningNumber = "3,15,18,23,27,38";
			WinningNumbers winningNumbers = new WinningNumbers(winningNumber);

			Lotto lotto1 = new Lotto(Arrays.asList(3, 15, 18, 24, 28, 39));
			Lotto lotto2 = new Lotto(Arrays.asList(3, 15, 18, 24, 27, 17));
			Lotto lotto3 = new Lotto(Arrays.asList(2, 11, 3, 22, 21, 19));
			Lotto lotto4 = new Lotto(Arrays.asList(5, 7, 9, 10, 11, 12));
			Lotto lotto5 = new Lotto(Arrays.asList(1, 4, 9, 20, 21, 22));
			List<Lotto> lottoTicket = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
			Checker checker = new Checker(lottoTicket, winningNumbers.getNumbers(), bonusNumber);

			Map<Grade, Integer> expected = new EnumMap<>(Grade.class);
			expected.put(Grade.FIFTH, 1);
			expected.put(Grade.FORTH, 1);
			expected.put(Grade.THIRD, 0);
			expected.put(Grade.SECOND, 0);
			expected.put(Grade.FIRST, 0);

			assertThat(expected).isEqualTo(checker.getWinGames());
		}

		@Test
		@DisplayName("2등이 당첨되었을때 SECOND의 count에 1을 추가한다.")
		void getTotalWinsTest2() {
			int bonusNumber = 17;
			String winningNumber = "3,15,18,23,27,38";
			WinningNumbers winningNumbers = new WinningNumbers(winningNumber);

			Lotto lotto1 = new Lotto(Arrays.asList(5, 12, 18, 24, 28, 39));
			Lotto lotto2 = new Lotto(Arrays.asList(3, 15, 18, 27, 23, 17));
			Lotto lotto3 = new Lotto(Arrays.asList(2, 11, 3, 22, 21, 19));
			Lotto lotto4 = new Lotto(Arrays.asList(5, 7, 9, 10, 11, 12));
			Lotto lotto5 = new Lotto(Arrays.asList(1, 4, 9, 20, 21, 22));
			List<Lotto> lottoTicket = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
			Checker checker = new Checker(lottoTicket, winningNumbers.getNumbers(), bonusNumber);

			Map<Grade, Integer> expected = new EnumMap<>(Grade.class);
			expected.put(Grade.FIFTH, 0);
			expected.put(Grade.FORTH, 0);
			expected.put(Grade.THIRD, 0);
			expected.put(Grade.SECOND, 1);
			expected.put(Grade.FIRST, 0);

			assertThat(expected).isEqualTo(checker.getWinGames());
		}

		@Test
		@DisplayName("3등이 당첨되었을때 THIRD의 count에 1을 추가한다.")
		void getTotalWinsTest3() {
			int bonusNumber = 17;
			String winningNumber = "3,15,18,23,27,38";
			WinningNumbers winningNumbers = new WinningNumbers(winningNumber);

			Lotto lotto1 = new Lotto(Arrays.asList(5, 12, 18, 24, 28, 39));
			Lotto lotto2 = new Lotto(Arrays.asList(3, 15, 18, 27, 23, 13));
			Lotto lotto3 = new Lotto(Arrays.asList(2, 11, 3, 22, 21, 19));
			Lotto lotto4 = new Lotto(Arrays.asList(5, 7, 9, 10, 11, 12));
			Lotto lotto5 = new Lotto(Arrays.asList(1, 4, 9, 20, 21, 22));
			List<Lotto> lottoTicket = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
			Checker checker = new Checker(lottoTicket, winningNumbers.getNumbers(), bonusNumber);

			Map<Grade, Integer> expected = new EnumMap<>(Grade.class);
			expected.put(Grade.FIFTH, 0);
			expected.put(Grade.FORTH, 0);
			expected.put(Grade.THIRD, 1);
			expected.put(Grade.SECOND, 0);
			expected.put(Grade.FIRST, 0);

			assertThat(expected).isEqualTo(checker.getWinGames());
		}
	}

	@Nested
	@DisplayName("로또의 총 상금을 구하는 기능 테스트")
	class getTotalCashPrizeTest {
		@Test
		@DisplayName("3등이 당첨되었을때 1500000을 반환한다.")
		void getTotalCashPrizeTest1() {
			int bonusNumber = 17;
			String winningNumber = "3,15,18,23,27,38";
			WinningNumbers winningNumbers = new WinningNumbers(winningNumber);

			Lotto lotto1 = new Lotto(Arrays.asList(5, 12, 18, 24, 28, 39));
			Lotto lotto2 = new Lotto(Arrays.asList(3, 15, 18, 27, 23, 13));
			Lotto lotto3 = new Lotto(Arrays.asList(2, 11, 3, 22, 21, 19));
			Lotto lotto4 = new Lotto(Arrays.asList(5, 7, 9, 10, 11, 12));
			Lotto lotto5 = new Lotto(Arrays.asList(1, 4, 9, 20, 21, 22));
			List<Lotto> lottoTicket = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
			Checker checker = new Checker(lottoTicket, winningNumbers.getNumbers(), bonusNumber);
			long expected = 1500000;

			assertThat(expected).isEqualTo(checker.getTotalCashPrize());
		}

		@Test
		@DisplayName("3등 1개, 5등 2개가 당첨되었을때 1510000을 반환한다.")
		void getTotalCashPrizeTest2() {
			int bonusNumber = 17;
			String winningNumber = "3,15,18,23,27,38";
			WinningNumbers winningNumbers = new WinningNumbers(winningNumber);

			Lotto lotto1 = new Lotto(Arrays.asList(3, 15, 18, 24, 28, 39));
			Lotto lotto2 = new Lotto(Arrays.asList(3, 15, 18, 27, 23, 13));
			Lotto lotto3 = new Lotto(Arrays.asList(3, 15, 23, 22, 21, 19));
			Lotto lotto4 = new Lotto(Arrays.asList(5, 7, 9, 10, 11, 12));
			Lotto lotto5 = new Lotto(Arrays.asList(1, 4, 9, 20, 21, 22));
			List<Lotto> lottoTicket = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
			Checker checker = new Checker(lottoTicket, winningNumbers.getNumbers(), bonusNumber);
			long expected = 1510000;

			assertThat(expected).isEqualTo(checker.getTotalCashPrize());
		}
	}
}
