package lotto.handler;

import java.util.Set;

import lotto.view.ErrorView;

public class CheckHandler {

	public static void isRest(int purchaseQuantity) {
		if (purchaseQuantity % 1000 > 0) {
			ExceptionHandler.raisingException(ErrorView.isExistRest());
		}
	}

	public static void isNumber(String input) {
		if (!input.matches("^[0-9]+$")) {
			ExceptionHandler.raisingException(ErrorView.isNotNumber());
		}
	}

	public static void isLotto(String input) {
		if (!input.matches("^[0-9,]+$")) {
			ExceptionHandler.raisingException(ErrorView.isNotLotto());
		}
	}

	public static void isLottoNumber(String input) {
		if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45) {
			ExceptionHandler.raisingException(ErrorView.isNotLotto());
		}
	}

	public static void isNotLotto(Set<Integer> lottoNumber) {
		if (lottoNumber.size() != 6) {
			ExceptionHandler.raisingException(ErrorView.isNotLottoNumberList());
		}
	}

}
