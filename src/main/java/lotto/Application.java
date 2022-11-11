package lotto;

import lotto.system.LottoSystem;
import lotto.system.NewLottoSystem;

public class Application {
	public static void main(String[] args) {
		// LottoSystem lottoSystem = new LottoSystem();
		// lottoSystem.lottoLogic();

		NewLottoSystem lottoSystem = new NewLottoSystem();
		lottoSystem.lottoLogic();
	}
}