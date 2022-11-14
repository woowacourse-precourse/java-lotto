package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Constant;
import lotto.exception.InputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String REG_XP_DIGITS = "^[0-9,]+$";

    private static final String SPLIT_STANDARD = ",";

    public static int inputLottoPurchaseAmount() {
        System.out.println(View.INPUT_PURCHASE.message());
        String input = Console.readLine();
        hasDigitsOnly(input);
        return Integer.parseInt(input);
    }

    private static void hasDigitsOnly(String purchaseAmount) {
        if (!purchaseAmount.matches(REG_XP_DIGITS)) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_DIGIT.message());
        }
    }

    public static List<Integer> inputUserWinNumber() {
        System.out.println(View.INPUT_WIN_NUMBER.message());
        String input = Console.readLine();
        isDigitAndSplitByStandard(input);
        return mapToList(input);
    }

    private static void isDigitAndSplitByStandard(String winNumbers) {
        if (!winNumbers.matches(REG_XP_DIGITS)) {
            throw new IllegalArgumentException(InputException.LOTTO_INVALID_FORM.message());
        }
    }

    private static List<Integer> mapToList(String winNumbers) {
        return Arrays.stream(winNumbers.split(SPLIT_STANDARD))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static int inputUserBonusNumber() {
        System.out.println(View.INPUT_BONUS_NUMBER.message());
        String input = Console.readLine();
        isBonusNumberDigit(input);
        return Integer.parseInt(input);
    }

    private static void isBonusNumberDigit(String bonusNumber) {
        if (bonusNumber.length() != Constant.BONUS_NUMBER_SIZE
                || !bonusNumber.matches(REG_XP_DIGITS)) {
            throw new IllegalArgumentException(InputException.BONUS_LOTTO_INVALID_FORM.message());
        }
    }
}
