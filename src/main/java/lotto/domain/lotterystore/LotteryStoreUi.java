package lotto.domain.lotterystore;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LotteryRequestController;
import lotto.domain.lotteryserver.LotteryServer;
import lotto.dto.lotteryseller.LottoSetsDto;
import lotto.dto.lotterystore.MoneyDto;
import lotto.dto.lotterystore.WinningNumbersDto;

import java.util.List;

public class LotteryStoreUi {
	private String winningPrizeNumbers;
	private LottoSetsDto lottoSetsDto;
	private String resultMessage;

	public void takeMoneyFromBuyer(LotteryRequestController requestController) {
		printPurchaseMessage();

		String money = Console.readLine();
		UIExceptions.validateMoneyFromBuyer(money);

		requestToTransferMoney(money, requestController);
		System.out.println();
	}

	public void takeWinningLotteryNumbers() {
		printMessageForWinningPrizeNumbers();

		String winningPrizeNumbers = Console.readLine();
		UIExceptions.validateWinningNumbers(winningPrizeNumbers);

		this.winningPrizeNumbers = winningPrizeNumbers;
		System.out.println();
	}

	public void takeBonusNumber(LotteryRequestController requestController,
		LotteryServer lotteryServer) {
		printMessageForBonusNumber();

		String bonusNumber = Console.readLine();
		UIExceptions.validateBonusNumbers(bonusNumber, winningPrizeNumbers);

		requestToTransferWinningPrizeNumbers(winningPrizeNumbers, bonusNumber, requestController,
			lotteryServer);
		System.out.println();
	}

	public void printPurchaseMessage() {
		System.out.println(Messages.LOTTO_BUY_INFO);
	}

	public void receiveLottoSets(LottoSetsDto lottoSetsDto) {
		this.lottoSetsDto = lottoSetsDto;
	}

	public void printMessageForLottoSets() {
		List<List<Integer>> sets = lottoSetsDto.getLottoSets();
		int size = lottoSetsDto.getLottoSetsSize();
		System.out.println(size + Messages.BUYING_COMPLETE);
		sets.forEach(System.out::println);
		System.out.println();
	}

	public void receiveResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public void printResultMessage() {
		System.out.println(resultMessage);
	}

	private void requestToTransferMoney(String money, LotteryRequestController requestController) {
		MoneyDto moneyDto = new MoneyDto(money);
		requestController.receiveMoney(moneyDto);
	}

	private void requestToTransferWinningPrizeNumbers(String winningPrizeNumbers,
		String bonusNumber, LotteryRequestController requestController,
		LotteryServer lotteryServer) {
		WinningNumbersDto winningNumbersDto =
			new WinningNumbersDto(winningPrizeNumbers, bonusNumber);
		requestController.receiveWinningNumbers(winningNumbersDto, lotteryServer);
	}

	private void printMessageForWinningPrizeNumbers() {
		System.out.println(Messages.LOTTO_NUMBER_INPUT);
	}

	private void printMessageForBonusNumber() {
		System.out.println(Messages.BONUS_NUMBER_INPUT);
	}
}
