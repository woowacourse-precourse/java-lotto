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
		LottoAmount lottoAmount = new LottoAmount(InputView.inputUserMoney());
		LottoTicket lottoTickets = buyLotto(lottoAmount);
		OutputView.printLottoTickets(lottoTickets);
		LottoResult lottoResult = makeLottoResult(lottoTickets);
		OutputView.printPrizeResult(lottoResult);
		double moneyResult = lottoAmount.calculatePrizeResult(lottoResult);
		OutputView.printRateReturn(moneyResult);
	}

	private LottoTicket buyLotto(LottoAmount lottoAmount) {
		int lottoCount = lottoAmount.calculateLottoCount();
		OutputView.printLottoNumber(lottoCount);
		return new LottoTicket(lottoCount);
	}

	private LottoResult makeLottoResult(LottoTicket lottoTickets) {
		WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumber());
		BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber(), winningNumber.getWinningNumber());
		return lottoTickets.calculateRank(winningNumber, bonusNumber);
	}
}
