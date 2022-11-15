package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Constants.PRICE;

public class Store {
	public long count;

	public Store(long pay) {
		count = pay / PRICE;
	}

	public List<List<Integer>> issueLottoTicket() {
		NumberGenerator numberGenerator = new NumberGenerator();
		List<List<Integer>> ticket = new ArrayList<>();

		for (int index = 0; index < count; index++) {
			Lotto lotto = new Lotto(numberGenerator.createRandomNumbers());
			ticket.add(lotto.getLotto());
		}
		return ticket;
	}
}
