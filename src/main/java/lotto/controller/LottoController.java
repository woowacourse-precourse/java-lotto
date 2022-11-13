package lotto.controller;

import java.util.HashMap;
import java.util.List;

import lotto.domain.BonusNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	int userMoney;

	public void run() {
		userMoney = InputView.inputUserMoney();
		InputView.validMoney(userMoney);
		List<List<Integer>> lottoTickets = chargeLottoPurchaseAmount(userMoney / 1000);
		List<Integer> winningNumbers = receiveWinningNumbers();
		int bonusNumber = receiveBonusNumber();
		winningNumberCount(lottoTickets, winningNumbers, bonusNumber);
	}

	public List<List<Integer>> chargeLottoPurchaseAmount(int ticketNumber) {
		LottoTicket lottoTicket = new LottoTicket(ticketNumber);
		List<List<Integer>> lottoTickets = lottoTicket.getLottoTickets();
		OutputView.printLottoNumber(ticketNumber);
		OutputView.printLottoTickets(lottoTickets);
		return lottoTickets;
	}

	public List<Integer> receiveWinningNumbers() {
		WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumber());
		winningNumber.validWinningNumber();
		return winningNumber.getWinningNumber();
	}

	private int receiveBonusNumber() {
		BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
		bonusNumber.validBonusNumber();
		return bonusNumber.getBonusNumber();
	}

	public void winningNumberCount(List<List<Integer>> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
		LottoResult lottoResult = new LottoResult(lottoTickets, winningNumbers, bonusNumber);
		double result = lottoResult.calculateRateReturn(userMoney);
		HashMap<String, Integer> prizeResult = lottoResult.getPrizeResult();
		OutputView.printPrize(prizeResult);
		OutputView.printRateReturn(result);
	}
}
