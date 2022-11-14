package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import lotto.constant.WinningRating;

class WinningStatisticsCompilerTest {

	@Test
	void getCountsOfWins() {
		List<Lotto> lotteries = List.of(
			new Lotto(List.of(2, 12, 15, 21, 27, 37)),
			new Lotto(List.of(4, 17, 22, 27, 41, 43)),
			new Lotto(List.of(5, 17, 19, 22, 32, 41)),
			new Lotto(List.of(2, 17, 19, 22, 32, 41)));
		WinningAndBonusNumbers winningAndBonusNumbers;
		winningAndBonusNumbers = new WinningAndBonusNumbers("5,17,19,22,32,41");
		WinningAndBonusNumbers winningAndBonusNumbers1 = new WinningAndBonusNumbers(2);
		WinningStatisticsCompiler winningStatisticsCompiler = new WinningStatisticsCompiler(lotteries,
			winningAndBonusNumbers1);
		assertThat(new ArrayList<>(winningStatisticsCompiler.getCountsOfWins().values())).isEqualTo(
			List.of(1, 1, 0, 0, 1, 1));
	}
}