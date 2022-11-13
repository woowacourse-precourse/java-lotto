package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.util.RankConst;

class RankTest {

	private RankGroup rankGroup;

	@BeforeEach
	void setUp() {
		rankGroup = new RankGroup();
	}

	@AfterEach
	void tearDown() {
		rankGroup.clearRankGroupCount();
	}

	@DisplayName("사용자에게 보여즐 rank 통계 정보 출력 확인 테스트")
	@Test
	void getUserStatisticsResult() {
		//given
		rankGroup.updateRankCount(Rank.firstRank, 1);

		//when
		String userStatisticsResult = rankGroup.userRankResultToString(Rank.firstRank);

		//then
		assertThat(userStatisticsResult).isEqualTo(RankConst.FIRST_RANK_RESULT + 1 + RankConst.COUNT);
	}
}
