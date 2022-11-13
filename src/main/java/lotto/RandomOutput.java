package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomOutput {
	private final int count;
	private final List<List<Integer>> lottoNumbers;
	
	RandomOutput(int count) {
		this.count = count;
		lottoNumbers = randomNumberslist(count);
	}
	
	private List<List<Integer>> randomNumberslist(int count) {
		List<List<Integer>> numbersList = new ArrayList<>();
		
		for(int i = 0; i < count; i++) {
			numbersList.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
		}
		
		return numbersList;
	}
	
	public int getCount() {
		return count;
	}
	
	public List<List<Integer>> getLottoNumbers() {
		return lottoNumbers;
	}
	
	
}
