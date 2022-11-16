package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.lottoConstant.Constant;

public class LottoResult {
	private final Map<LottoRanking, Integer> LottoResult = new EnumMap<>(LottoRanking.class);

	public LottoResult(List<LottoRanking> lottoRankings) {
		settingLottoResult();
		createLottoResult(lottoRankings);
	}

	private void settingLottoResult() {
		List<LottoRanking> rank = Arrays.stream(LottoRanking.values()).collect(Collectors.toList());
		for (LottoRanking lottoRank : rank) {
			LottoResult.put(lottoRank, Constant.ZERO_NUMBER);
		}
	}

	private void createLottoResult(List<LottoRanking> lottoRankings) {
		for (LottoRanking lottoRanking : lottoRankings) {
			int winLottoCount = LottoResult.get(lottoRanking) + Constant.UPDATE_ONE_COUNT;
			LottoResult.put(lottoRanking, winLottoCount);
		}
	}

	public Map<LottoRanking, Integer> getLottoResult() {
		return LottoResult;
	}
}
