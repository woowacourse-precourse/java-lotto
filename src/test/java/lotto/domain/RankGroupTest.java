package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
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
	void findYieldTest() {
		//given
		Integer buyPrice = 3000;
		rankGroup.updateRankCount(Rank.firstRank, 1);
		rankGroup.updateRankCount(Rank.secondRank, 2);

		//when

		double yield = rankGroup.findYield(buyPrice);
		int sum = (RankConst.FIRST_RANK_PRICE * 1) + (RankConst.SECOND_RANK_PRICE * 2);
		double result = Math.round(sum * 1000d / (double)buyPrice) / 10d;

		//then
		assertThat(yield).isEqualTo(result);
	}

	@DisplayName("사용자가 당첨된 등수 횟수 업데이트 테스트")
	@Test
	void updateCountTest() {
		//given
		Integer addNumber = 100;
		rankGroup.updateRankCount(Rank.firstRank, addNumber);

		//when
		Integer rankCountTest = rankGroup.findRankCount(Rank.firstRank);

		//then
		assertThat(rankCountTest).isEqualTo(addNumber);
	}

	@DisplayName("사용자에게 보여즐 rank 통계 정보 출력 확인 테스트")
	@Test
	void getUserStatisticsResultTest() {
		//given
		rankGroup.updateRankCount(Rank.firstRank, 1);

		//when
		String userStatisticsResult = rankGroup.userRankResultToString(Rank.firstRank);

		//then
		assertThat(userStatisticsResult).isEqualTo(RankConst.FIRST_RANK_RESULT + 1 + RankConst.COUNT_STATEMENT);
	}

	@Test
	public void userTotalRankResultTest() {
		//given
		rankGroup.updateRankCount(Rank.firstRank, 1);
		rankGroup.updateRankCount(Rank.secondRank, 2);
		List<String> userTotalRankResult = new ArrayList<>();
		userTotalRankResult.add(rankGroup.userRankResultToString(Rank.fifthRank));
		userTotalRankResult.add(rankGroup.userRankResultToString(Rank.forthRank));
		userTotalRankResult.add(rankGroup.userRankResultToString(Rank.thirdRank));
		userTotalRankResult.add(rankGroup.userRankResultToString(Rank.secondRank));
		userTotalRankResult.add(rankGroup.userRankResultToString(Rank.firstRank));

		//when
		List<String> userTotalRankResultTest = rankGroup.userTotalRankResult();

		//then
		Assertions.assertThat(userTotalRankResult).isEqualTo(userTotalRankResultTest);
	}

}
