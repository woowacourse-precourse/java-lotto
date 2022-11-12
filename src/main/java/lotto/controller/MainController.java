package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoCompany;
import lotto.model.LottoMachine;
import lotto.model.Wallet;
import lotto.view.InputView;
import lotto.view.LottoInformationView;

public class MainController {
	private final InputView inputView = InputView.getInstance();

	public void run() {
		int purchaseAmountInput = Integer.parseInt(Console.readLine());
		LottoCompany lottoCompany = inputView.createWinningLotto();
		Wallet wallet = new LottoMachine(purchaseAmountInput).buyLotto();

		viewLotto(wallet.getMyLotto().size(), wallet.getMyLotto());
	}

	public void viewLotto(int lottoCount, List<Lotto> myLotto) {
		new LottoInformationView(lottoCount, myLotto);
	}
}
