package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Stats;
import lotto.domain.WinningLotto;
import lotto.service.MachineSystem;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
	private MachineSystem machineSystem;

	public void run() {
		try {
			setting();
			winningStats();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void setting() {
		Buyer buyer = Buyer.buyLottos(InputView.inputAmount());
		OutputView.printAllLottoNumber(buyer.getLotto());

		WinningLotto winningLotto = WinningLotto.generateWinningLotto(InputView.inputWinningNumber());
		winningLotto.setBonusNumber(InputView.inputBonusNumber());
		machineSystem = new MachineSystem(buyer, winningLotto);
	}

	private void winningStats() {
		Stats stats = Stats.initStats();
		stats.addLottos(machineSystem.matchLottos());
		stats.print();
		OutputView.printYieldMessage(stats.yield());
	}
}
