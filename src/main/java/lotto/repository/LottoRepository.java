package lotto.repository;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import lotto.domain.Lotto;

public class LottoRepository {

	public static final int QUANTITY_OF_NUMBERS = 6;
	public static final int NUMBER_MAX_RANGE = 46;

	public static Lotto makeAutoLotto() {
		Set<Integer> numbers = new TreeSet<>();
		while (numbers.size() < QUANTITY_OF_NUMBERS) {
			numbers.add((int)(Math.random() * NUMBER_MAX_RANGE));
		}
		return new Lotto(new ArrayList<>(numbers));
	}

}
