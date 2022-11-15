package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsCollectorTest {
	@DisplayName("각 등수별 당첨 횟수를 구한다.")
	@Test
	void getCountsOfWins() {
		List<Lotto> lotteries = List.of(
			new Lotto(List.of(2, 12, 15, 21, 27, 37)),
			new Lotto(List.of(4, 17, 22, 27, 41, 43)),
			new Lotto(List.of(5, 17, 19, 22, 32, 41)),
			new Lotto(List.of(2, 17, 19, 22, 32, 41)));
		WinningNumbers winningNumbers;
		winningNumbers = new WinningNumbers("5,17,19,22,32,41");
		BonusNumber bonusNumber = new BonusNumber(2, winningNumbers);
		WinningStatisticsCollector winningStatisticsCollector = new WinningStatisticsCollector(lotteries,
			winningNumbers, bonusNumber);
		assertThat(new ArrayList<>(winningStatisticsCollector.getCountsOfWins().values())).isEqualTo(
			List.of(1, 1, 0, 0, 1, 1));
	}
}