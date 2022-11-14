package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String CHECK_NUMBER = "[-+]?\\d*\\.?\\d+";

    public static Integer inputPaidAmount() {
        String AmountString = Console.readLine();
        validateNumber(AmountString);
        validateAmount(AmountString);
        return Integer.parseInt(AmountString);
    }

    private static void validateNumber(String amountString) {
        if (!isNumeric(amountString)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_AMOUNT_NUMBER_MESSAGE.getValue());
        }
    }

    public static boolean isNumeric(String amountString) {
        return amountString != null && amountString.matches(CHECK_NUMBER);
    }

    private static void validateAmount(String amountString) {
        if (Integer.parseInt(amountString) % LottoNumberRule.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_AMOUNT_MESSAGE.getValue());
        }
    }

    public static List<Integer> inputWinningNumber() {
        String winningNumberString = Console.readLine();
        String[] winningNumberStrings = winningNumberString.split(",");
        validateLottoNumbers(winningNumberStrings);
        return Arrays.stream(winningNumberStrings).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validateLottoNumbers(String[] winningNumberStrings) {
        for (String numberString : winningNumberStrings) {
            validateLottoNumber(numberString);
        }
    }

    private static void validateLottoNumber(String numberString) {
        if (!isNumeric(numberString)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBER_MESSAGE.getValue());
        }
    }

    public static Integer inputBonusNumber() {
        String bonusNumberString = Console.readLine();
        validateBonusNumber(bonusNumberString);
        return Integer.parseInt(bonusNumberString);
    }

    private static void validateBonusNumber(String bonusNumberString) {
        if (!isNumeric(bonusNumberString)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER_MESSAGE.getValue());
        }
    }
}
