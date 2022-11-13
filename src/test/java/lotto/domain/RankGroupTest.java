package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.util.RankConst;

class RankGroupTest {

	private RankGroup rankGroup;

	@BeforeEach
	void setUp() {
		rankGroup = new RankGroup();
	}

	@AfterEach
	void tearDown() {
		rankGroup.clearRankGroupCount();
	}

	@DisplayName("수익률 계산 확인 테스트")
	@Test
	void findYield() {
		//given
		Integer buyPrice = 3000;
		rankGroup.updateRankCount(Rank.firstRank, 1);
		rankGroup.updateRankCount(Rank.secondRank, 2);

		//when

		double yield = rankGroup.findYield(buyPrice);
		int sum = (2_000_000_000 * 1) + (30_000_000 * 2);
		double result = Math.round(sum * 1000d / (double)buyPrice) / 10d;

		//then
		assertThat(yield).isEqualTo(result);
	}

	@DisplayName("사용자가 당첨된 등수 횟수 업데이트 테스트")
	@Test
	void updateCount() {
		//given
		Integer addNumber = 100;
		rankGroup.updateRankCount(Rank.firstRank, addNumber);

		//when
		String userStatisticsResult = rankGroup.userRankResultToString(Rank.firstRank);

		//then
		assertThat(userStatisticsResult).isEqualTo(RankConst.FIRST_RANK_RESULT + addNumber + RankConst.COUNT);
	}

	@Test
	void updateRankCount() {
	}

	@Test
	void userRankResultToString() {
	}

	@Test
	void clearRankGroupCount() {
	}

}
