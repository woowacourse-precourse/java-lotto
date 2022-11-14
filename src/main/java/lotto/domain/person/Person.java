package lotto.domain.person;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoAutoGenerator;
import lotto.domain.money.Money;

public class Person {

	private Money money;
	private List<Lotto> lottos;
	private LottoAutoGenerator lottoAutoGenerator;

	public Person(String price) {
		this.money = new Money(price);
		this.lottos = new ArrayList<>();
		this.lottoAutoGenerator = new LottoAutoGenerator();
	}

	public void buyLotto() {
		lottos = lottoAutoGenerator.createLottoAccordingToTheAmount(money);
	}
}
