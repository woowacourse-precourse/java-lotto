package lotto.dto.lotteryseller;

import java.util.List;

public class RandomNumbersSets {
	private final List<List<Integer>> randomNumbersSets;
	public RandomNumbersSets(List<List<Integer>> randomNumbersSets) {
		this.randomNumbersSets =randomNumbersSets;
	}

	public List<List<Integer>> getRandomNumbersSets() {
		return randomNumbersSets;
	}
}
