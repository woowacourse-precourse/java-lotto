package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
	int count;
	List<List<Integer>> lottoTicket;


	public Store(int pay) {
		new Pay(pay);
		count = pay / 1000;
	}

	void issueLottoTicket(){
		NumberGenerator numberGenerator = new NumberGenerator();
		lottoTicket= new ArrayList<>();
		for (int index = 0 ; index < count ; index++){
			Lotto lotto = new Lotto(numberGenerator.createRandomNumbers());
			lottoTicket.add(lotto.get());
		}
	}
}
