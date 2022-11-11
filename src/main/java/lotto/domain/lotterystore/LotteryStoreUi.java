package lotto.domain.lotterystore;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LotteryRequestController;
import lotto.dto.lotterystore.MoneyForPurchase;
import lotto.dto.lotterystore.NumbersForWinningPrize;

public class LotteryStoreUi {
	private static final LotteryStoreUi storeUi = new LotteryStoreUi();
	private static final ErrorChecker errorChecker = new ErrorChecker();
	private final LotteryRequestController requestController;

	private LotteryStoreUi() {
		this.requestController = LotteryRequestController.getController();
	}

	public static LotteryStoreUi getStoreUi() {
		return storeUi;
	}

	public void takeMoneyFromBuyer() {
		printPurchaseMessage();

		String money = Console.readLine();
		errorChecker.validateMoneyFromBuyer(money);

		requestForTransferingMoneyForPurchase(money);
	}

	public void takeWinningLotteryNumbers() {
		printMessageForWinningPrizeNumbers();

		String winningNumbers = Console.readLine();
		errorChecker.validateWinningNumbers(winningNumbers);

		requestForTransferingWinningPrizeNumbers(winningNumbers);
	}

	private void printPurchaseMessage() {
		System.out.println("구매금액을 입력해 주세요.");
	}

	private void printMessageForWinningPrizeNumbers() {
		System.out.println("당첨 번호를 입력해 주세요.");
	}

	private void requestForTransferingMoneyForPurchase(String money) {
		// FrontEnd에서 API를 호출해서 데이터 전송하는 것과 비슷하게(??) 구현
		MoneyForPurchase moneyDto = new MoneyForPurchase(money);
		requestController.receiveMoneyForPurchase(moneyDto);
	}

	private void requestForTransferingWinningPrizeNumbers(String winningNumbers) {
		// FrontEnd에서 API를 호출해서 데이터 전송하는 것과 비슷하게(??) 구현
		NumbersForWinningPrize winningNumbersDto = new NumbersForWinningPrize(winningNumbers);
		requestController.receiveNumbersForWinningPrize(winningNumbersDto);
	}
}
