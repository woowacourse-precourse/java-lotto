package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;

//todo 상수들만 모은 클래스 만들기
public class Store {
	public long count;
	final int PRICE = 1000;

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
