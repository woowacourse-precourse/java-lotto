package lotto.core;

import lotto.models.Lotto;
import lotto.models.LottoResult;
import lotto.models.Rank;
import lotto.models.WinningLotto;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoManager {

	private final WinningLotto winningLotto;
	private final List<Lotto> userLotteries;

	public LottoManager(WinningLotto winningLotto, List<Lotto> userLotteries) {
		this.winningLotto = winningLotto;
		this.userLotteries = userLotteries;
	}

	public LottoResult getUserLotteriesResult() {
		Map<Rank, Long> result = countResultRankFromUserLotteries();
		return new LottoResult(result);
	}

	protected Map<Rank, Long> countResultRankFromUserLotteries() {
		return userLotteries.stream()
				.map(winningLotto::compareTo)
				.filter(rank -> !rank.isOutOfRank())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
}
