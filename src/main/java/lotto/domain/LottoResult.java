package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
	private static final int RATE_MULTIPLE_NUMBER = 100;
	private final Map<LottoRanking, Integer> LottoResult = new EnumMap<>(LottoRanking.class);

	public LottoResult(List<LottoRanking> lottoRankings) {
		settingLottoResult();
		makeLottoResult(lottoRankings);
	}

	private void settingLottoResult() {
		List<LottoRanking> rank = Arrays.stream(LottoRanking.values()).collect(Collectors.toList());
		for (LottoRanking lottoRank : rank) {
			LottoResult.put(lottoRank, 0);
		}
	}

	private void makeLottoResult(List<LottoRanking> lottoRankings) {
		for (LottoRanking lottoRanking : lottoRankings) {
			int winLottoCount = LottoResult.get(lottoRanking) + 1;
			LottoResult.put(lottoRanking, winLottoCount);
		}
	}

	public Map<LottoRanking, Integer> getLottoResult() {
		return LottoResult;
	}
}
