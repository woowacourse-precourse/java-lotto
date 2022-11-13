package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomOutput {
	private final int count;
	private final List<List<Integer>> lottoNumbers;
	private static StringBuilder builder;
	
	RandomOutput(int count) {
		this.count = count;
		lottoNumbers = randomNumberslist(count);
	}
	
	private List<List<Integer>> randomNumberslist(int count) {
		List<List<Integer>> numbersList = new ArrayList<>();
		List<Integer> randomNumbers;
		
		builder.append(count + "개를 구매했습니다.\n");
		
		for(int i = 0; i < count; i++) {
			randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			numbersList.add(randomNumbers);
			builder.append(randomNumbers);
			
			if(i != count - 1) {
				builder.append("\n");
			}
		}
		
		return numbersList;
	}
	
	public int getCount() {
		return count;
	}
	
	public List<List<Integer>> getLottoNumbers() {
		return lottoNumbers;
	}
	
	public String toString() {
		return builder.toString();
	}
}
