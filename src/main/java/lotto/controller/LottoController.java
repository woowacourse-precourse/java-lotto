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
		WinningNumber winningNumber = makeWinningNumber();
		winningNumberCount(lottoAmount, winningNumbers, bonusNumber);
	}

	public LottoTicket buyLotto(LottoAmount lottoAmount) {
		int lottoCount = lottoAmount.calculateLottoCount();
		LottoTicket lottoTicket = new LottoTicket(lottoCount);
		OutputView.printLottoNumber(lottoCount);
		OutputView.printLottoTickets(lottoTicket);
		return lottoTicket;
	}

	public WinningNumber makeWinningNumber() {
		WinningNumber inputWinningNumber = new WinningNumber(InputView.inputWinningNumber());
		BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
	}

	public void winningNumberCount(LottoAmount lottoAmount, List<Integer> winningNumbers, int bonusNumber) {
		LottoResult lottoResult = new LottoResult(lottoTickets, winningNumbers, bonusNumber);
		double result = lottoResult.calculateRateReturn();
		HashMap<String, Integer> prizeResult = lottoResult.getPrizeResult();
		OutputView.printPrize(prizeResult);
		OutputView.printRateReturn(result);
	}
}
