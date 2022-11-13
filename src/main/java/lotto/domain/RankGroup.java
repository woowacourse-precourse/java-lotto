package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.util.RankConst;

public class RankGroup {

	private Map<Rank, Integer> rankGroup; //Rank, 당첨 Rank 별 횟수

	public RankGroup() {
		this.rankGroup = new HashMap<>();
		rankGroup.put(Rank.firstRank, 0);
		rankGroup.put(Rank.secondRank, 0);
		rankGroup.put(Rank.thirdRank, 0);
		rankGroup.put(Rank.forthRank, 0);
		rankGroup.put(Rank.fifthRank, 0);
	}

	public void updateRankCount(Rank rank, Integer number) {
		rankGroup.put(rank, rankGroup.get(rank) + number);
	}

	public String userRankResultToString(Rank rank) {
		return rank.getRankCountDescription() + rankGroup.get(rank) + RankConst.COUNT;
	}

	public void clearRankGroupCount() {
		rankGroup.forEach(((rank, integer) -> rankGroup.put(rank, 0)));
	}

	public Double findYield(Integer buyPrice) {
		double sum = Arrays.stream(Rank.values())
			.mapToDouble(i -> i.getPrice() * rankGroup.get(i))
			.reduce(0, (total, y) -> total + y);
		return Double.valueOf(Math.round(sum * 1000d / (double)buyPrice) / 10d);
	}

	public List<String> userTotalRankResult() {
		List<String> userTotalRankResult = new ArrayList<>();
		Arrays.stream(Rank.values()).forEach(i -> userTotalRankResult.add(userRankResultToString(i)));
		return userTotalRankResult;
	}

}
