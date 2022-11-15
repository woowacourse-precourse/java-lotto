package lotto.domain.model;

import java.util.List;

public class RateOfReturn {
	private long prize = 0;
	public double rateOfReturn;

	public RateOfReturn(long pay, List<List<Integer>> score) {
		getPrize(score);
		getRateOfReturn(pay);
	}

	private void getRateOfReturn(long pay) {
		rateOfReturn = ((double) prize - pay) / pay * 100;
	}

	private void getPrize(List<List<Integer>> score) {
		for (List<Integer> eachScore : score) {
			if (eachScore.get(2) > 0) {
				prize += (long) eachScore.get(1) * eachScore.get(2);
			}
		}
	}
}
