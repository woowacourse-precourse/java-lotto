package lotto.service;

import java.util.List;

public class StatisticsDto {

	private List<String> userTotalRankResult;
	private Double yield;

	public StatisticsDto(List<String> userTotalRankResult, Double yield) {
		this.userTotalRankResult = userTotalRankResult;
		this.yield = yield;
	}

	public List<String> getUserTotalRankResult() {
		return userTotalRankResult;
	}

	public Double getYield() {
		return yield;
	}
}
