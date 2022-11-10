package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Buyer;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

	private Buyer buyer;
	private WinningLotto winningLotto;

	public void run() {
		setting();
	}

	private void setting() {
		buyer = new Buyer(InputView.inputAmount());
		OutputView.printAllLottoNumber(buyer.getLotto());

		String winningNumbers = InputView.inputWinningNumber();
		winningLotto = new WinningLotto(convertNumber(winningNumbers));

	}

	private List<Integer> convertNumber(String numbers) {
		return Arrays.stream(numbers.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
