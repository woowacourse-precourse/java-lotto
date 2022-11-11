package lotto.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		Validator.isListValidate(numbers);
		this.numbers = numbers;
	}

	public static List<List<Integer>> generateLotto(int count) {
		List<List<Integer>> lottoGames = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			sort(numbers);
			lottoGames.add(numbers);
		}
		return lottoGames;
	}

	public static List<Integer> sort(List<Integer> numbers){
		List<Integer> result = new ArrayList<>(numbers);
		Collections.sort(result);
		return result;
	}


	public List<Integer> getNumbers() {
		return numbers;
	}
}
