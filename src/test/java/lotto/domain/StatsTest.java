package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatsTest {

	@Test
	@DisplayName("당첨 내역에 따른 상금")
	void checkTotalRewardTest() {
		Stats stats = Stats.initStats();
		stats.addLotto(Rank.RANK_1ST);
		stats.addLotto(Rank.RANK_2ND);
		int sum = Rank.RANK_1ST.getReward() + Rank.RANK_2ND.getReward();
		Assertions.assertThat(stats.totalReward()).isEqualTo(sum);
	}

	@Test
	@DisplayName("수익률 계산해주는 테스트")
	void calculateYieldTest() {
		Stats stats = Stats.initStats();
		stats.addLotto(Rank.RANK_4TH);
		stats.addLotto(Rank.RANK_5TH);
		double amount = 2000;
		double totalReward = Rank.RANK_4TH.getReward() + Rank.RANK_5TH.getReward();
		double yield = totalReward / amount * 100;
		Assertions.assertThat(stats.yield()).isEqualTo(yield);
	}
}
