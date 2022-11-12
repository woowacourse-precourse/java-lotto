package lotto.domain;

import lotto.Calculation;
import lotto.LottoIssuer;

import java.util.stream.Stream;

public class Game {

	public void run() {
		Player player = new Player();
		long totalAmount = player.receiveTotalAmount();
		new LottoIssuer(totalAmount);
		Stream<Integer> lottoNumbers = player.receiveLottoNumber();
		player.receiveBonusNumber(lottoNumbers);

		Calculation.findMatch();
		Calculation.calculateResult();
		Calculation.calculateProfit(totalAmount);
	}
}
