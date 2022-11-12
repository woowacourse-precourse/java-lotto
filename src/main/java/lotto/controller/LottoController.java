package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.BonusNumber;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	InputView inputView = new InputView();
	int userMoney;
	List<List<Integer>> lottoTickets;
	List<Integer> winningNumbers;
	HashMap<String, Integer> prizeResult;
	int bonusNumber;

	public void run() {
		chargeLottoPurchaseAmount();
		receiveWinningNumbers();
		receiveBonusNumber();
		winningNumberCount();
	}

	public void chargeLottoPurchaseAmount() {
		int userMoney = inputView.inputUserMoney();
		inputView.validMoney(userMoney);
		int ticketNumber = userMoney / 1000;
		LottoTicket lottoTicket = new LottoTicket(ticketNumber);
		lottoTickets = lottoTicket.createLottoTickets();
		OutputView.printLottoNumber(ticketNumber);
		OutputView.printLottoTickets(lottoTickets);
	}

	public void receiveWinningNumbers() {
		WinningNumber winningNumber = new WinningNumber(inputView.inputWinningNumber());
		winningNumber.validWinningNumber();
	}

	public void receiveBonusNumber() {
		BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
		bonusNumber.validBonusNumber();
	}

	public void winningNumberCount() {
		double result;
		LottoResult lottoResult = new LottoResult(lottoTickets, winningNumbers, bonusNumber);
		result = lottoResult.calculateRateReturn(userMoney);
		prizeResult = lottoResult.getPrizeResult();
		OutputView.printPrize(prizeResult);
		OutputView.printRateReturn(result);
	}
}
