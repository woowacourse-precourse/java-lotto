package lotto.handler;

import lotto.view.ErrorView;

public class CheckHandler {

	public static void isRest(int purchaseQuantity) {
		if (purchaseQuantity % 1000 > 0) {
			ExceptionHandler.raisingException(ErrorView.isRest());
		}
	}

	public static void isNumber(String purchaseQuantity) {
		if (!purchaseQuantity.matches("^[0-9]+$")) {
			ExceptionHandler.raisingException(ErrorView.isNotNumber());
		}
	}

}
