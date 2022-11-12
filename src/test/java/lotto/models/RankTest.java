package lotto.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RankTest {

	@DisplayName("Rank.NONE 은 순위권 밖인지 확인하는 테스트")
	@Test
	void test() {
		final Rank none = Rank.NONE;

		boolean result = none.isOutOfRank();

		assertThat(result).isTrue();
	}

	@ParameterizedTest(name = "{0} 는 1~5 사이의 숫자이기 때문에 순위권이다.")
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void checkValidRangeOfRankTest(int rankValue) {
		Rank rank = Rank.getRank(rankValue);

		boolean result = rank.isOutOfRank();

		assertThat(result).isFalse();
	}

	@ParameterizedTest(name = "{0} 는 1~5의 범위 밖이기 때문에 순위권 밖이다.")
	@ValueSource(ints = {0, -2, 6})
	void checkOutOfRangeRankTest(int rankValue) {
		Rank rank = Rank.getRank(rankValue);

		boolean result = rank.isOutOfRank();

		assertThat(result).isTrue();
	}

	@ParameterizedTest(name = "일치하는 숫자 개수:{0} => 1개 또는 2개만 맞췄을 경우 순위권 밖임을 확인하는 테스트")
	@ValueSource(ints = {1, 2})
	void checkNoneRankTest(int matchedCount) {
		Rank rank = Rank.getRankByMatchedNumberCount(matchedCount);

		boolean result = rank.isOutOfRank();

		assertThat(result).isTrue();
	}

	@DisplayName("3개를 맞췄을 경우 5등임을 확인하는 테스트")
	@Test
	void checkFifthRankTest() {
		final int matchedCount = 3;
		Rank rank = Rank.getRankByMatchedNumberCount(matchedCount);

		final Rank expected = Rank.FIFTH;
		assertThat(rank).isEqualTo(expected);
	}

	@DisplayName("4개를 맞췄을 경우 4등임을 확인하는 테스트")
	@Test
	void checkFourthRankTest() {
		final int matchedCount = 4;
		Rank rank = Rank.getRankByMatchedNumberCount(matchedCount);

		final Rank expected = Rank.FOURTH;
		assertThat(rank).isEqualTo(expected);
	}

	@DisplayName("6개를 맞췄을 경우 1등임을 확인하는 테스트")
	@Test
	void checkFirstRankTest() {
		final int matchedCount = 6;
		Rank rank = Rank.getRankByMatchedNumberCount(matchedCount);

		final Rank expected = Rank.FIRST;
		assertThat(rank).isEqualTo(expected);
	}
}