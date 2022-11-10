package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		Set<Integer> numbersHashSet = new HashSet<>();
		for (int i = 0; i < numbers.size(); i++) {
			numbersHashSet.add(numbers.get(i));
		}
		if (numbersHashSet.size() != 6) {
			throw new IllegalArgumentException();
		}
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	public static List<List<Integer>> generateLotto(int count) {
		List<List<Integer>> lottoGames = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Collections.sort(numbers);
			lottoGames.add(numbers);
		}
		return lottoGames;
	}
}
