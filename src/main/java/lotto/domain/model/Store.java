package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;

//todo 상수들만 모은 클래스 만들기
public class Store {
	public int count;	// todo  테스트만을 위한 퍼블릭?
	final int PRICE = 1000;
	public LottoTicket lottoTicket;

	public Store(int pay) {
		count = pay / PRICE;
		issueLottoTicket();
	}

	void issueLottoTicket() {
		NumberGenerator numberGenerator = new NumberGenerator();
		List<List<Integer>> ticket = new ArrayList<>();

		for (int index = 0; index < count; index++) {
			Lotto lotto = new Lotto(numberGenerator.createRandomNumbers());
			ticket.add(lotto.getLotto());
		}
		lottoTicket = new LottoTicket(ticket);
	}
}
