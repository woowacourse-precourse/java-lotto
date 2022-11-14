package lotto.models;

import java.util.Map;

import static lotto.constants.Constant.*;

public class LottoResult {
	double earningRate;
	Map<Rank, Long> lotteriesResult;

	public LottoResult(Map<Rank, Long> lotteriesResult) {
		this.lotteriesResult = lotteriesResult;
	}

	public int getRankCount(Rank rank) {
		return Math.toIntExact(lotteriesResult.getOrDefault(rank, NOT_COUNTED));
	}
}
