package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RankTest {
	@DisplayName("맞춘 번호 갯수와 보너스번호 포함 여부를 판단하여 등수를 리턴한다.")
	@Nested
	class GetProfitRateTest {
		@Test
		void case1() {
			Rank rank = Rank.of(6, false);
			assertEquals(rank, Rank.FIRST);
		}

		@Test
		void case2() {
			Rank rank = Rank.of(5, true);
			assertEquals(rank, Rank.SECOND);
		}

		@Test
		void case3() {
			Rank rank = Rank.of(5, false);
			assertEquals(rank, Rank.THIRD);
		}

		@Test
		void case4() {
			Rank rank = Rank.of(4, true);
			assertEquals(rank, Rank.FOURTH);
		}

		@Test
		void case5() {
			Rank rank = Rank.of(4, false);
			assertEquals(rank, Rank.FOURTH);
		}

		@Test
		void case6() {
			Rank rank = Rank.of(3, true);
			assertEquals(rank, Rank.FIFTH);
		}

		@Test
		void case7() {
			Rank rank = Rank.of(3, false);
			assertEquals(rank, Rank.FIFTH);
		}

		@Test
		void case8() {
			Rank rank = Rank.of(2, true);
			assertEquals(rank, Rank.MISS);
		}

		@Test
		void case9() {
			Rank rank = Rank.of(2, false);
			assertEquals(rank, Rank.MISS);
		}

		@Test
		void case10() {
			Rank rank = Rank.of(1, true);
			assertEquals(rank, Rank.MISS);
		}

		@Test
		void case11() {
			Rank rank = Rank.of(1, false);
			assertEquals(rank, Rank.MISS);
		}

		@Test
		void case12() {
			Rank rank = Rank.of(0, true);
			assertEquals(rank, Rank.MISS);
		}

		@Test
		void case13() {
			Rank rank = Rank.of(0, false);
			assertEquals(rank, Rank.MISS);
		}
	}

	@DisplayName("등수에 맞는 맞춘 갯수를 리턴한다.")
	@Nested
	class GetHitNumberCountTest {
		@Test
		void case1() {
			assertEquals(Rank.FIRST.getHitNumberCount(), 6);
		}

		@Test
		void case2() {
			assertEquals(Rank.SECOND.getHitNumberCount(), 5);
		}

		@Test
		void case3() {
			assertEquals(Rank.THIRD.getHitNumberCount(), 5);
		}

		@Test
		void case4() {
			assertEquals(Rank.FOURTH.getHitNumberCount(), 4);
		}

		@Test
		void case5() {
			assertEquals(Rank.FIFTH.getHitNumberCount(), 3);
		}

		@Test
		void case6() {
			assertEquals(Rank.MISS.getHitNumberCount(), 0);
		}
	}

	@DisplayName("등수에 맞는 당첨금을 리턴한다.")
	@Nested
	class GetPrizeMoneyTest {
		@Test
		void case1() {
			assertEquals(Rank.FIRST.getPrizeMoney(), 2_000_000_000);
		}

		@Test
		void case2() {
			assertEquals(Rank.SECOND.getPrizeMoney(), 30_000_000);
		}

		@Test
		void case3() {
			assertEquals(Rank.THIRD.getPrizeMoney(), 1_500_000);
		}

		@Test
		void case4() {
			assertEquals(Rank.FOURTH.getPrizeMoney(), 50_000);
		}

		@Test
		void case5() {
			assertEquals(Rank.FIFTH.getPrizeMoney(), 5_000);
		}

		@Test
		void case6() {
			assertEquals(Rank.MISS.getPrizeMoney(), 0);
		}
	}

	@DisplayName("등수에 맞는 당첨금을 통화형식에 맞게 리턴한다.")
	@Nested
	class GetPrizeMoneyWithCommaTest {
		@Test
		void case1() {
			assertEquals(Rank.FIRST.getPrizeMoneyWithComma(), "2,000,000,000");
		}

		@Test
		void case2() {
			assertEquals(Rank.SECOND.getPrizeMoneyWithComma(), "30,000,000");
		}

		@Test
		void case3() {
			assertEquals(Rank.THIRD.getPrizeMoneyWithComma(), "1,500,000");
		}

		@Test
		void case4() {
			assertEquals(Rank.FOURTH.getPrizeMoneyWithComma(), "50,000");
		}

		@Test
		void case5() {
			assertEquals(Rank.FIFTH.getPrizeMoneyWithComma(), "5,000");
		}

		@Test
		void case6() {
			assertEquals(Rank.MISS.getPrizeMoneyWithComma(), "0");
		}
	}
}
