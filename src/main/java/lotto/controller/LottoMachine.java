package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Buyer;
import lotto.domain.Stats;
import lotto.domain.WinningLotto;
import lotto.service.MachineSystem;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

	private static final String REST_REGEX = ",";
	private MachineSystem machineSystem;

	public void run() {
		setting();
		winningStats();
	}

	private void setting() {
		Buyer buyer = new Buyer(InputView.inputAmount());
		OutputView.printAllLottoNumber(buyer.getLotto());

		String winningNumbers = InputView.inputWinningNumber();
		WinningLotto winningLotto = new WinningLotto(convertNumber(winningNumbers));
		winningLotto.setBonusNumber(InputView.inputBonusNumber());
		machineSystem = new MachineSystem(buyer, winningLotto);
	}

	private List<Integer> convertNumber(String numbers) {
		return Arrays.stream(numbers.split(REST_REGEX))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private void winningStats() {
		Stats stats = machineSystem.createStats();
		stats.print();
	}
}
