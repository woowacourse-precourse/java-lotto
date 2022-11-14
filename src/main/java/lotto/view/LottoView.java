package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.view.constant.InputMessage.*;
import static lotto.view.constant.OutputMessage.*;

public class LottoView {

	public static void displayInputPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT);
	}

	public static void displayPurchasedLottoAmount(int purchasedLottoCount) {
		System.out.printf(OUTPUT_PURCHASE_AMOUNT, purchasedLottoCount);
	}

	public static String getUserInput() {
		return readLine();
	}
}
