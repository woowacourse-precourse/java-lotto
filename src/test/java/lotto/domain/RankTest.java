package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.util.RankConst;

class RankTest {

	@DisplayName("수익률 계산 확인 테스트")
	@Test
	void findYield() {
		//given
		Integer buyPrice = 3000;
		Rank.firstRank.updateCount(1);
		Rank.secondRank.updateCount(2);

		//when
		double yield = Rank.findYield(buyPrice);
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
		Rank.firstRank.updateCount(addNumber);

		//when
		String userStatisticsResult = Rank.firstRank.getUserStatisticsResult();

		//then
		assertThat(userStatisticsResult).isEqualTo(RankConst.FIRST_RANK_RESULT + addNumber + RankConst.COUNT);
	}

	@DisplayName("사용자에게 보여즐 rank 통계 정보 출력 확인 테스트")
	@Test
	void getUserStatisticsResult() {
		//given
		Rank.firstRank.updateCount(1);

		//when
		String userStatisticsResult = Rank.firstRank.getUserStatisticsResult();

		//then
		assertThat(userStatisticsResult).isEqualTo(RankConst.FIRST_RANK_RESULT + 1 + RankConst.COUNT);
	}
}
