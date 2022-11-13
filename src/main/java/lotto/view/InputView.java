package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String ERROR_NUMBER_MESSAGE = "구입금액은 숫자여야 합니다.";
    private static final String ERROR_AMOUNT_MESSAGE = "구입금액은 1000원 단위여야 합니다.";
    private static final Integer LOTTO_PRICE = 1000;
    public static Integer inputPaidAmount() {
	String AmountString = Console.readLine();
	validateNumber(AmountString);
	validateAmount(AmountString);
	return Integer.parseInt(AmountString);
    }

    public static boolean isNumeric(String amountString) {
	return amountString != null && amountString.matches("[-+]?\\d*\\.?\\d+");
    }

    private static void validateNumber(String amountString) {
	if (!isNumeric(amountString)) {
	    throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_NUMBER_MESSAGE);
	}
    }

    private static void validateAmount(String amountString) {
	if (Integer.parseInt(amountString) % LOTTO_PRICE != 0) {
	    throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_AMOUNT_MESSAGE);
	}
    }
}
