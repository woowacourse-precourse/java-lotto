package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Numbers {
	private final List<List<Integer>> numbers;
	
	public Numbers(int lottoCount) {
		numbers = randomNumbers(lottoCount);
	}
	
	private List<List<Integer>> randomNumbers(int lottoCount) {
		List<List<Integer>> randomPick = new ArrayList<>();
		
		for (int i = 0; i < lottoCount; i++) {
			List<Integer> list = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6)); 
			Collections.sort(list);
			randomPick.add(list);
		}
		
		return randomPick;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (List<Integer> list : numbers) {
			builder.append(list);
			builder.append("\n");
		}
		
		return builder.toString();
	}
	
	public List<List<Integer>> getNumbers() {
		return numbers;
	}
}
