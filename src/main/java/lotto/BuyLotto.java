package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Print.Message;
import camp.nextstep.edu.missionutils.Randoms;

public class BuyLotto {
	public BuyLotto() {
	}

	public static List<Lotto> print(int n) {
		List<Lotto> lotto_list = new ArrayList<>();

		Message.LOTTO_COUNT.print_count(n);
		for (int i = 0; i < n; i++) {
			lotto_list.add(new Lotto(input()));

			ArrayList<Integer> numbers = new ArrayList<>(lotto_list.get(i).getnumber());

			Collections.sort(numbers);

			System.out.println(numbers);
		}

		return lotto_list;
	}

	private static List<Integer> input() {
		List<Integer> input_number;

		input_number = Randoms.pickUniqueNumbersInRange(1, 45, 6);

		return input_number;
	}
}
