package lotto.domain;

import java.util.ArrayList;
import java.util.List;

//todo 상수들만 모은 클래스 만들기
public class Store {
	int count;
	List<List<Integer>> lottoTicket;
	final int PRICE = 1000;

	public Store(int pay) {
		new Pay(pay);
		count = pay / PRICE;
		issueLottoTicket();
	}

	void issueLottoTicket() {
		NumberGenerator numberGenerator = new NumberGenerator();
		lottoTicket = new ArrayList<>();

		for (int index = 0; index < count; index++) {
			Lotto lotto = new Lotto(numberGenerator.createRandomNumbers());
			lottoTicket.add(lotto.getLotto());
		}
	}
}
