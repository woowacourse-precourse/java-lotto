package lotto.dto.lotteryseller;

import java.util.List;

public class RandomNumbersSets {
	private final List<List<Integer>> randomNumbersSets;
	private final int randomNumbersSetsSize;

	public RandomNumbersSets(List<List<Integer>> randomNumbersSets, int randomNumbersSetsSize) {
		this.randomNumbersSets = randomNumbersSets;
		this.randomNumbersSetsSize = randomNumbersSetsSize;
	}

	public List<List<Integer>> getRandomNumbersSets() {
		return randomNumbersSets;
	}

	public int getRandomNumbersSetsSize() {
		return randomNumbersSetsSize;
	}
}
