package lotto.calculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class calculateProfitability {
	public double calculateProfitability;
	public calculateProfitability(HashMap<String, Integer> result, ArrayList<List<Integer>> userNumber) {
		double purchasePrice = userNumber.size() * 1000;
		double prize = (result.get("three") * 5000) + (result.get("four") * 50000) + (result.get("five") * 1500000) +
			(result.get("bonus") * 30000000) + (result.get("six") * 2000000000);
		this.calculateProfitability = (double)Math.round((prize * 1000 / purchasePrice)) / 10;
	}

}
