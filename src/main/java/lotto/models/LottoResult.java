package lotto.models;

import java.util.Map;

public class LottoResult {
	double earningRate;
	Map<Rank, Long> lotteriesResult;

	public LottoResult(Map<Rank, Long> lotteriesResult) {
		this.lotteriesResult = lotteriesResult;
	}
}
