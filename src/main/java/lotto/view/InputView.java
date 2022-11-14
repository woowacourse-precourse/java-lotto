package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String CHECK_NUMBER = "[-+]?\\d*\\.?\\d+";

    public static Integer inputPaidAmount() {
        String inputAmount = Console.readLine();
        validateNumber(inputAmount);
        validateAmount(inputAmount);
        return Integer.parseInt(inputAmount);
    }

    private static void validateNumber(String inputAmount) {
        if (!isNumeric(inputAmount)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_AMOUNT_NUMBER_MESSAGE.getValue());
        }
    }

    public static boolean isNumeric(String inputAmount) {
        return inputAmount != null && inputAmount.matches(CHECK_NUMBER);
    }

    private static void validateAmount(String inputAmount) {
        if (Integer.parseInt(inputAmount) % LottoNumberRule.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_AMOUNT_MESSAGE.getValue());
        }
    }

    public static List<Integer> inputWinningNumber() {
        String inputWinningNumber = Console.readLine();
        String[] inputWinningNumbers = inputWinningNumber.split(",");
        validateLottoNumbers(inputWinningNumbers);
        return Arrays.stream(inputWinningNumbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validateLottoNumbers(String[] inputWinningNumbers) {
        for (String inputWinningNumber : inputWinningNumbers) {
            validateLottoNumber(inputWinningNumber);
        }
    }

    private static void validateLottoNumber(String inputWinningNumbers) {
        if (!isNumeric(inputWinningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBER_MESSAGE.getValue());
        }
    }

    public static Integer inputBonusNumber() {
        String inputBonusNumber = Console.readLine();
        validateBonusNumber(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private static void validateBonusNumber(String inputBonusNumber) {
        if (!isNumeric(inputBonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER_MESSAGE.getValue());
        }
    }
}
