package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
	private static int purchaseAmount;

	public void inputPurchaseAmount() {
		System.out.println(Message.INPUT_PURCHASE_AMOUNT_MESSAGE);
		purchaseAmount = Integer.parseInt(readLine());
	}
}
