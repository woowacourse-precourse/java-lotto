package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.view.constant.InputMessage.*;

public class LottoView {

	public static void displayInputPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT);
	}
	
	public static String getUserInput() {
		return readLine();
	}
}
