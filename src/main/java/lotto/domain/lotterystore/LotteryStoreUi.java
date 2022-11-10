package lotto.domain.lotterystore;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.lotterystore.NumberForPurchase;

public class LotteryStoreUi {
	private static final ErrorChecker errorChecker = new ErrorChecker();

	public void takeMoneyFromBuyer() {
		int moneyForPurchase;
		printPurchaseMessage();

		String money = Console.readLine();
		errorChecker.ValidateMoneyFromBuyer(money);

		moneyForPurchase = Integer.parseInt(money);
		transferNumbersForPurchase(moneyForPurchase);
	}

	private void printPurchaseMessage() {
		System.out.println("구매금액을 입력해 주세요.");
	}

	private int setNumbersForPurchase(int money) {
		return money / 1000;
	}

	private void transferNumbersForPurchase(int money) {
		// API를 호출해서 데이터 전송하는 것과 비슷하게?? 구현
		int numberOfPurchase = setNumbersForPurchase(money);
		NumberForPurchase numberDto = new NumberForPurchase(numberOfPurchase);
	}
}
