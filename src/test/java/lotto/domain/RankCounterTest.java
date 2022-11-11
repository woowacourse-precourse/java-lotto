package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RankCounterTest {
	@DisplayName("복권들과 당첨번호를 입력하면 등수를 맵형태로 알려준다")
	@Nested
	class GetRanksTest {
		@Test
		void case1() {

			List<Lotto> lottoTickets = List.of(
				new Lotto(List.of(8, 21, 23, 41, 42, 43)),
				new Lotto(List.of(3, 5, 11, 16, 32, 38)),
				new Lotto(List.of(7, 11, 16, 35, 36, 44)),
				new Lotto(List.of(1, 8, 11, 31, 41, 42)),
				new Lotto(List.of(13, 14, 16, 38, 42, 45)),
				new Lotto(List.of(7, 11, 30, 40, 42, 43)),
				new Lotto(List.of(2, 13, 22, 32, 38, 45)),
				new Lotto(List.of(1, 3, 5, 14, 22, 45))
			);
			WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");

			Map<Rank, Integer> ranks = Map.ofEntries(
				Map.entry(Rank.FIRST, 0),
				Map.entry(Rank.SECOND, 0),
				Map.entry(Rank.THIRD, 0),
				Map.entry(Rank.FOURTH, 0),
				Map.entry(Rank.FIFTH, 1),
				Map.entry(Rank.MISS, 7)
			);
			RankCounter rankCounter = new RankCounter(lottoTickets, winningNumbers);
			System.out.println(ranks);
			assertEquals(rankCounter.getRanks(), ranks);
		}

		@Test
		void case2() {

			List<Lotto> lottoTickets = List.of(
				new Lotto(List.of(1, 2, 3, 4, 5, 6)),
				new Lotto(List.of(1, 2, 3, 4, 5, 6)),
				new Lotto(List.of(1, 2, 3, 4, 5, 7)),
				new Lotto(List.of(1, 8, 11, 31, 41, 42)),
				new Lotto(List.of(13, 14, 16, 38, 42, 45)),
				new Lotto(List.of(7, 11, 30, 40, 42, 43)),
				new Lotto(List.of(2, 13, 22, 32, 38, 45)),
				new Lotto(List.of(1, 3, 5, 14, 22, 45))
			);
			WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");

			Map<Rank, Integer> ranks = Map.ofEntries(
				Map.entry(Rank.FIRST, 2),
				Map.entry(Rank.SECOND, 1),
				Map.entry(Rank.THIRD, 0),
				Map.entry(Rank.FOURTH, 0),
				Map.entry(Rank.FIFTH, 1),
				Map.entry(Rank.MISS, 4)
			);
			RankCounter rankCounter = new RankCounter(lottoTickets, winningNumbers);
			System.out.println(ranks);
			assertEquals(rankCounter.getRanks(), ranks);
		}

		@Test
		void case3() {

			List<Lotto> lottoTickets = List.of(
				new Lotto(List.of(1, 2, 3, 4, 5, 6)),
				new Lotto(List.of(1, 2, 3, 4, 5, 6)),
				new Lotto(List.of(1, 2, 3, 4, 5, 7)),
				new Lotto(List.of(1, 2, 3, 4, 5, 8)),
				new Lotto(List.of(1, 2, 3, 4, 42, 45)),
				new Lotto(List.of(7, 11, 30, 40, 42, 43)),
				new Lotto(List.of(2, 13, 22, 32, 38, 45)),
				new Lotto(List.of(1, 3, 5, 14, 22, 45))
			);
			WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");

			Map<Rank, Integer> ranks = Map.ofEntries(
				Map.entry(Rank.FIRST, 2),
				Map.entry(Rank.SECOND, 1),
				Map.entry(Rank.THIRD, 1),
				Map.entry(Rank.FOURTH, 1),
				Map.entry(Rank.FIFTH, 1),
				Map.entry(Rank.MISS, 2)
			);
			RankCounter rankCounter = new RankCounter(lottoTickets, winningNumbers);
			System.out.println(ranks);
			assertEquals(rankCounter.getRanks(), ranks);
		}
	}
}
