package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String ERROR_AMOUNT_NUMBER_MESSAGE = "구입금액은 숫자여야 합니다.";
    private static final String ERROR_AMOUNT_MESSAGE = "구입금액은 1000원 단위여야 합니다.";
    private static final String ERROR_LOTTO_NUMBER_MESSAGE = "로또번호는 숫자여야 합니다.";
    private static final Integer LOTTO_PRICE = 1000;

    public static Integer inputPaidAmount() {
	String AmountString = Console.readLine();
	validateNumber(AmountString);
	validateAmount(AmountString);
	return Integer.parseInt(AmountString);
    }

    public static List<Integer> inputWinningNumber() {
	String winningNumberString = Console.readLine();
	String[] winningNumberStrings = winningNumberString.split(",");
	validateLottoNumbers(winningNumberStrings);
	return Arrays.stream(winningNumberStrings).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static boolean isNumeric(String amountString) {
	return amountString != null && amountString.matches("[-+]?\\d*\\.?\\d+");
    }

    private static void validateNumber(String amountString) {
	if (!isNumeric(amountString)) {
	    throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_AMOUNT_NUMBER_MESSAGE);
	}
    }

    private static void validateAmount(String amountString) {
	if (Integer.parseInt(amountString) % LOTTO_PRICE != 0) {
	    throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_AMOUNT_MESSAGE);
	}
    }

    private static void validateLottoNumbers(String[] winningNumberStrings) {
	for (String numberString: winningNumberStrings) {
	    validateLottoNumber(numberString);
	}
    }

    private static void validateLottoNumber(String numberString) {
	if (!isNumeric(numberString)) {
	    throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_LOTTO_NUMBER_MESSAGE);
	}
    }
}
