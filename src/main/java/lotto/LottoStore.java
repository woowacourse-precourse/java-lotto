package lotto;

import java.util.ArrayList;
import java.util.List;


public class LottoStore {

	private int moneyBuyLotto;
	private List<Lotto> lottos;

	public LottoStore() {
		moneyBuyLotto = 0;
		lottos = new ArrayList<>();
	}

	public void open() {
		buy();
		publish();
	}

	private void buy() {
		ConsoleOut.printInputMoney();
		moneyBuyLotto = Util.strToInt(ConsoleIn.readLine());
		Verify.verifyThousandUnit(moneyBuyLotto);
	}

	private void publish() {
		int numLotto = moneyBuyLotto / Constants.MINIMUM_MONEY_UNIT;
		severalLottoPublish(numLotto);
	}

	private void severalLottoPublish(int numLotto) {
		for (int num = 1; num <= numLotto; num++) {
			Lotto lotto = new Lotto(
				Util.pickUniqueNumbersInRange(Constants.LOTTO_UNDER_BOUNDARY, Constants.LOTTO_UPPER_BOUNDARY,
					Constants.LOTTO_LENGTH));
			lottos.add(lotto);
		}
	}
}