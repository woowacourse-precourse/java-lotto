package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Constant;
import lotto.exception.InputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static String inputLottoPurchaseAmount() {
        System.out.println(View.INPUT_PURCHASE.message());
        return Console.readLine();
    }

    public static List<Integer> inputUserWinNumber() {
        System.out.println(View.INPUT_WIN_NUMBER.message());
        String input = Console.readLine();
        isDigitAndSplitByStandard(input);
        return mapToList(input);
    }

    private static void isDigitAndSplitByStandard(String winNumbers) {
        if (!winNumbers.matches(Constant.REG_XP_DIGITS)) {
            throw new IllegalArgumentException(InputException.LOTTO_INVALID_FORM.message());
        }
    }

    private static List<Integer> mapToList(String winNumbers) {
        return Arrays.stream(winNumbers.split(Constant.SPLIT_STANDARD))
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
                || !bonusNumber.matches(Constant.REG_XP_DIGITS)) {
            throw new IllegalArgumentException(InputException.BONUS_LOTTO_INVALID_FORM.message());
        }
    }
}
