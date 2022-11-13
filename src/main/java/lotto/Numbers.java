package lotto;

import java.util.ArrayList;
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
			randomPick.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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
	
	public static void main(String[] args) {
		Numbers numbers = new Numbers(6);
		System.out.println(numbers.toString());
	}
}
