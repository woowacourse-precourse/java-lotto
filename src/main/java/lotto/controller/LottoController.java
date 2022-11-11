package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	InputView inputView = new InputView();
	int userMoney;
	List<List<Integer>> lottoTickets;
	List<Integer> winningNumbers;
	HashMap<String, Integer> prizeCount;
	int bonusNumber;

	public void run() {
		chargeLottoPurchaseAmount();
		receiveWinningNumbers();
		receiveBonusNumber();
		winningNumberCount();
		calculateRateReturn();
	}

	public void chargeLottoPurchaseAmount() {
		String userInput = inputView.inputUserMoney();
		inputView.validMoney(userInput);
		userMoney = Integer.parseInt(userInput);
		int ticketNumber = userMoney / 1000;
		LottoTicket lottoTicket = new LottoTicket(ticketNumber);
		lottoTickets = lottoTicket.createLottoTickets();
		OutputView.printLottoNumber(ticketNumber);
		OutputView.printLottoTickets(lottoTickets);
	}

	public void receiveWinningNumbers() {
		String userInput = inputView.inputWinningNumber();
		inputView.validWinningNumber(userInput);
		winningNumbers = Arrays.stream(userInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());
	}

	public void receiveBonusNumber() {
		String userInput = inputView.inputBonusNumber();
		inputView.validBonusNumber(userInput);
		bonusNumber = Integer.parseInt(userInput);

	}

	public void winningNumberCount() {
		LottoResult lottoResult = new LottoResult(lottoTickets, winningNumbers, bonusNumber);
		prizeCount = lottoResult.countWin();
		OutputView.printPrize(prizeCount);
	}

	public void calculateRateReturn() {
		long sum = 0L;
		double result;
		sum += prizeCount.get("firstPrize") * 200000000 ;
		sum += prizeCount.get("secondPrize") * 30000000;
		sum += prizeCount.get("thirdPrize") * 1500000;
		sum += prizeCount.get("fourthPrize") * 50000;
		sum += prizeCount.get("fifthPrize") * 5000;

		result = Math.round((double)sum / userMoney * 100);
		OutputView.printRateReturn(result);
	}
}
