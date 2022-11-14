package lotto.system;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		Validator.isSizeValidate(numbers);
		this.numbers = numbers;
	}

	public static List<List<Integer>> generateLotto(int count) {
		List<List<Integer>> lottoGames = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			List<Integer> game = numbers.stream()
				.sorted()
				.collect(Collectors.toList());
			lottoGames.add(game);
		}
		return lottoGames;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
