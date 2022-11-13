package lotto.controller;

import java.util.HashMap;
import java.util.List;

import lotto.domain.BonusNumber;
import lotto.domain.LottoAmount;
import lotto.domain.LottoRanking;
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

		OutputView.printPrizeResult(lottoResult);
		OutputView.printRateReturn(lottoAmount.calculatePrizeResult(lottoResult));
	}

	private LottoAmount createLottoAmount() {
		return new LottoAmount(InputView.inputUserMoney());
	}

	private LottoTicket buyLotto(LottoAmount lottoAmount) {
		int lottoCount = lottoAmount.calculateLottoCount();
		OutputView.printLottoNumber(lottoCount);
		return new LottoTicket(lottoCount);
	}

	private LottoResult createLottoResult(LottoTicket tickets, WinningNumber winningNumber, BonusNumber bonusNumber) {
		return tickets.calculateRank(winningNumber, bonusNumber);
	}

	private WinningNumber createWinningNumber() {
		return new WinningNumber(InputView.inputWinningNumber());
	}

	private BonusNumber createBonusNumber(WinningNumber winningNumber) {
		return new BonusNumber(InputView.inputBonusNumber(), winningNumber.getWinningNumber());
	}
}
