package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatsTest {

	@Test
	@DisplayName("당첨 내역에 따른 상금")
	void checkTotalRewardTest() {
		Stats stats = Stats.initStats();
		stats.add(Rank.RANK_1ST);
		stats.add(Rank.RANK_2ND);
		int sum = Rank.RANK_1ST.getReward() + Rank.RANK_2ND.getReward();
		Assertions.assertThat(stats.totalReward()).isEqualTo(sum);
	}
}
