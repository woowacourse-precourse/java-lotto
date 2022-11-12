package lotto.domain;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.service.MachineSystem;

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

	@Test
	@DisplayName("수익률 계산해주는 테스트")
	void calculateYieldTest() {
		Stats stats = Stats.initStats();
		stats.add(Rank.RANK_1ST);
		stats.add(Rank.RANK_2ND);
		String amount = "10000";
		MachineSystem machineSystem = new MachineSystem(new Buyer(amount),
			new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

		double totalReward = Rank.RANK_1ST.getReward() + Rank.RANK_2ND.getReward();
		double yield = totalReward / Double.parseDouble(amount) * 100;
		Assertions.assertThat(machineSystem.yield(stats.totalReward())).isEqualTo(yield);
	}
}
