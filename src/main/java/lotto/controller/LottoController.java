package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoAmount;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void run() {
		LottoAmount lottoAmount = createLottoAmount();

		LottoTicket lottoTickets = buyLotto(lottoAmount);
		OutputView.printLottoTickets(lottoTickets);

		WinningNumber winningNumber = createWinningNumber();
		BonusNumber bonusNumber = createBonusNumber(winningNumber);

		LottoResult lottoResult = createLottoResult(lottoTickets, winningNumber, bonusNumber);
		printResult(lottoResult, lottoAmount);
	}

	private LottoAmount createLottoAmount() {
		return new LottoAmount(InputView.inputUserMoney());
	}

	private LottoTicket buyLotto(LottoAmount lottoAmount) {
		int lottoCount = lottoAmount.calculateLottoCount();
		OutputView.printLottoNumber(lottoCount);
		return new LottoTicket(lottoCount);
	}

	private WinningNumber createWinningNumber() {
		return new WinningNumber(InputView.inputWinningNumber());
	}

	private BonusNumber createBonusNumber(WinningNumber winningNumber) {
		return new BonusNumber(InputView.inputBonusNumber(), winningNumber.getWinningNumber());
	}

	private LottoResult createLottoResult(LottoTicket tickets, WinningNumber winningNumber, BonusNumber bonusNumber) {
		return tickets.calculateRank(winningNumber, bonusNumber);
	}

	private void printResult(LottoResult lottoResult, LottoAmount lottoAmount) {
		OutputView.printPrizeResult(lottoResult);
		OutputView.printRateReturn(lottoAmount.calculatePrizeResult(lottoResult));
	}
}
