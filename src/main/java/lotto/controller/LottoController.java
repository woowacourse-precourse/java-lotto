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
		WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumber());
		BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber(), winningNumber.getWinningNumber());
		LottoResult lottoResult = makeLottoResult(lottoTickets, winningNumber, bonusNumber);
		calculatePrize(lottoResult);
	}

	private LottoTicket buyLotto(LottoAmount lottoAmount) {
		int lottoCount = lottoAmount.calculateLottoCount();
		LottoTicket lottoTicket = new LottoTicket(lottoCount);
		OutputView.printLottoNumber(lottoCount);
		OutputView.printLottoTickets(lottoTicket);
		return lottoTicket;
	}

	private LottoResult makeLottoResult(LottoTicket lottoTickets, WinningNumber winningNumbers, BonusNumber bonusNumber) {
		LottoResult lottoResult = lottoTickets.calculateRank(winningNumbers, bonusNumber);
		return lottoResult;
	}

	private void calculatePrize(LottoResult lottoResult) {

	}
}
