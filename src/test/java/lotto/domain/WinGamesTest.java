package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("WinGames 클래스")
class WinGamesTest {
	abstract class ExpectedWinGames {
		void putCount(Map<Grade, Integer> winGames, Grade grade, int count) {
			winGames.put(grade, count);
		}

		void resetWinGames(Map<Grade, Integer> winGames) {
			winGames.put(Grade.FIFTH, 0);
			winGames.put(Grade.FORTH, 0);
			winGames.put(Grade.THIRD, 0);
			winGames.put(Grade.SECOND, 0);
			winGames.put(Grade.FIRST, 0);
		}

	}

	@Nested
	@DisplayName("getTotalWins 메소드는")
	class Describe_getTotalWins extends ExpectedWinGames {
		@Nested
		@DisplayName("만약 각각의 로또 숫자들과 당첨숫자들이 각각 4개, 5개 일치한다면")
		class Context_lotto_numbers_match_four_and_five_winning_numbers {
			private final int bonusNumber = 17;
			private final String winningNumber = "3,15,18,23,27,38";
			private final Lotto lotto1 = new Lotto(Arrays.asList(3, 15, 18, 24, 28, 39));
			private final Lotto lotto2 = new Lotto(Arrays.asList(3, 15, 18, 24, 27, 17));
			private final Lotto lotto3 = new Lotto(Arrays.asList(2, 11, 3, 22, 21, 19));
			private final Lotto lotto4 = new Lotto(Arrays.asList(5, 7, 9, 10, 11, 12));
			private final Lotto lotto5 = new Lotto(Arrays.asList(1, 4, 9, 20, 21, 22));

			@Test
			@DisplayName("FORTH, FIFTH의 count에 각각 1씩 추가한다.")
			void it_returns_forth_count_one_and_fifth_count_one() {
				WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
				List<Lotto> lottoTicket = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
				WinGames winGames = new WinGames(lottoTicket, winningNumbers.getNumbers(), bonusNumber);

				Map<Grade, Integer> expected = new EnumMap<>(Grade.class);
				resetWinGames(expected);
				putCount(expected, Grade.FIFTH, 1);
				putCount(expected, Grade.FORTH, 1);

				assertThat(expected).isEqualTo(winGames.getWinGames());
			}
		}


		@Nested
		@DisplayName("만약 로또 숫자들과 당첨숫자들이 5개, 보너스 숫자가 일치한다면")
		class Context_lotto_numbers_match_five_winning_numbers_and_bonus_number {
			private final int bonusNumber = 17;
			private final String winningNumber = "3,15,18,23,27,38";
			private final Lotto lotto1 = new Lotto(Arrays.asList(5, 12, 18, 24, 28, 39));
			private final Lotto lotto2 = new Lotto(Arrays.asList(3, 15, 18, 27, 23, 17));
			private final Lotto lotto3 = new Lotto(Arrays.asList(2, 11, 3, 22, 21, 19));
			private final Lotto lotto4 = new Lotto(Arrays.asList(5, 7, 9, 10, 11, 12));
			private final Lotto lotto5 = new Lotto(Arrays.asList(1, 4, 9, 20, 21, 22));

			@Test
			@DisplayName("SECOND의 count에 1을 추가한다.")
			void it_returns_second_count_one() {
				WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
				List<Lotto> lottoTicket = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
				WinGames winGames = new WinGames(lottoTicket, winningNumbers.getNumbers(), bonusNumber);

				Map<Grade, Integer> expected = new EnumMap<>(Grade.class);
				resetWinGames(expected);
				putCount(expected, Grade.SECOND, 1);

				assertThat(expected).isEqualTo(winGames.getWinGames());
			}
		}

		@Nested
		@DisplayName("만약 로또 숫자들과 당첨숫자들이 5개 일치한다면")
		class Context_lotto_numbers_match_five_winning_numbers {
			private final int bonusNumber = 17;
			private final String winningNumber = "3,15,18,23,27,38";
			private final Lotto lotto1 = new Lotto(Arrays.asList(5, 12, 18, 24, 28, 39));
			private final Lotto lotto2 = new Lotto(Arrays.asList(3, 15, 18, 27, 23, 13));
			private final Lotto lotto3 = new Lotto(Arrays.asList(2, 11, 3, 22, 21, 19));
			private final Lotto lotto4 = new Lotto(Arrays.asList(5, 7, 9, 10, 11, 12));
			private final Lotto lotto5 = new Lotto(Arrays.asList(1, 4, 9, 20, 21, 22));

			@Test
			@DisplayName("THIRD의 count에 1을 추가한다.")
			void it_returns_third_count_one() {
				WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
				List<Lotto> lottoTicket = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
				WinGames winGames = new WinGames(lottoTicket, winningNumbers.getNumbers(), bonusNumber);

				Map<Grade, Integer> expected = new EnumMap<>(Grade.class);
				resetWinGames(expected);
				putCount(expected, Grade.THIRD, 1);

				assertThat(expected).isEqualTo(winGames.getWinGames());
			}
		}
	}

	@Nested
	@DisplayName("getTotalWins 메소드는")
	class Describe_getTotalCashPrize {
		@Nested
		@DisplayName("만약 3등이 1개 당첨되었다면")
		class Context_third_grade_win_one {
			private final int bonusNumber = 17;
			private final String winningNumber = "3,15,18,23,27,38";
			private final Lotto lotto1 = new Lotto(Arrays.asList(5, 12, 18, 24, 28, 39));
			private final Lotto lotto2 = new Lotto(Arrays.asList(3, 15, 18, 27, 23, 13));
			private final Lotto lotto3 = new Lotto(Arrays.asList(2, 11, 3, 22, 21, 19));
			private final Lotto lotto4 = new Lotto(Arrays.asList(5, 7, 9, 10, 11, 12));
			private final Lotto lotto5 = new Lotto(Arrays.asList(1, 4, 9, 20, 21, 22));

			@Test
			@DisplayName("상금 1,500,000을 반환한다.")
			void it_returns_cash_prize_for_third_grade() {
				WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
				List<Lotto> lottoTicket = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
				WinGames winGames = new WinGames(lottoTicket, winningNumbers.getNumbers(), bonusNumber);

				long expected = 1_500_000;
				assertThat(expected).isEqualTo(winGames.getTotalCashPrize());
			}
		}

		@Nested
		@DisplayName("만약 3등 1개, 5등 2개가 당첨되었다면")
		class Context_third_grade_win_one_and_fifth_grade_win_two {
			private final int bonusNumber = 17;
			private final String winningNumber = "3,15,18,23,27,38";
			private final Lotto lotto1 = new Lotto(Arrays.asList(3, 15, 18, 24, 28, 39));
			private final Lotto lotto2 = new Lotto(Arrays.asList(3, 15, 18, 27, 23, 13));
			private final Lotto lotto3 = new Lotto(Arrays.asList(3, 15, 23, 22, 21, 19));
			private final Lotto lotto4 = new Lotto(Arrays.asList(5, 7, 9, 10, 11, 12));
			private final Lotto lotto5 = new Lotto(Arrays.asList(1, 4, 9, 20, 21, 22));

			@Test
			@DisplayName("상금 1,510,000을 반환한다.")
			void it_returns_one_cash_prize_for_third_grade_and_two_cash_prize_for_fifth_grade() {
				WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
				List<Lotto> lottoTicket = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
				WinGames winGames = new WinGames(lottoTicket, winningNumbers.getNumbers(), bonusNumber);

				long expected = 1_510_000;
				assertThat(expected).isEqualTo(winGames.getTotalCashPrize());
			}
		}
	}
}
