package lotto.controller;

import java.util.HashMap;
import java.util.List;

import lotto.domain.BonusNumber;
import lotto.domain.LottoAmount;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void run() {
		LottoAmount lottoAmount = new LottoAmount(InputView.inputUserMoney());
		LottoTicket lottoTickets = buyLotto(lottoAmount);
		WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumber());
		BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber(), winningNumber.getWinningNumber());
		calculateResult(lottoTickets, winningNumber, bonusNumber);
	}

	public LottoTicket buyLotto(LottoAmount lottoAmount) {
		int lottoCount = lottoAmount.calculateLottoCount();
		LottoTicket lottoTicket = new LottoTicket(lottoCount);
		OutputView.printLottoNumber(lottoCount);
		OutputView.printLottoTickets(lottoTicket);
		return lottoTicket;
	}

	public void calculateResult(LottoTicket lottoTicket, WinningNumber winningNumbers, BonusNumber bonusNumber) {
		LottoResult lottoResult = new LottoResult(lottoTicket, winningNumbers, bonusNumber);
		double result = lottoResult.calculateRateReturn();
		HashMap<String, Integer> prizeResult = lottoResult.getPrizeResult();
		OutputView.printPrize(prizeResult);
		OutputView.printRateReturn(result);
	}

	private LottoResult calculateWinCount() {

	}
}
