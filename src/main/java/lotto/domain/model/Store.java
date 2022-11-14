package lotto.domain.model;

import lotto.domain.model.Lotto;
import lotto.domain.model.NumberGenerator;
import lotto.domain.model.Pay;

import java.util.ArrayList;
import java.util.List;

//todo 상수들만 모은 클래스 만들기
public class Store {
	int count;
	public List<List<Integer>> lottoTicket; //todo 단일클래스로 빼기
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
