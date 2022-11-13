package lotto.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
	private static final int RATE_MULTIPLE_NUMBER = 100;
	private long winResult = 0;
	private final Map<LottoRanking, Integer> LottoResult = new EnumMap<>(LottoRanking.class);

	public LottoResult(List<LottoRanking> lottoRankings) {
		for (LottoRanking lottoRanking : lottoRankings) {
			int winLottoCount = LottoResult.getOrDefault(lottoRanking, 0) + 1;
			LottoResult.put(lottoRanking, winLottoCount);
		}
	}
}
