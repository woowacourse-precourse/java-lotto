package lotto.view;

import static lotto.util.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.Validation;

public class InputView {

    // 구입 금액을 입력하는 기능
    public static int purchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY_MSG);
        String money = Console.readLine();
        Validation.validatePurchaseMoneyConsistOfNum(money);
        Validation.validatePurchaseMoneyGreaterThan1000(money);
        Validation.validatePurchaseMoney(money);
        return Integer.parseInt(money);
    }

    // 당첨 번호를 입력하는 기능
    public static List<Integer> winningNumberInput() {
        System.out.println(INPUT_WINNING_LOTTO_MSG);
        String winningNumber = Console.readLine();
        Validation.validateWinningNumberContainCommaAndNum(winningNumber);
        Validation.validateWinningNumberStartOrEndWithComma(winningNumber);
        Validation.validateWinningNumberSplitCommaConsistOfNum(winningNumber);
        return stringListToIntegerList(splitString(winningNumber));
    }

    // 보너스 번호를 입력하는 기능
    public static int bounusNumberInput() {
        System.out.println(INPUT_BONUS_MSG);
        String bonusNumber = Console.readLine();
        Validation.validateBonusNumberConsistOfNum(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    // 문자열을 ,를 기준으로 분리하는 기능
    private static List<String> splitString(String input) {
        return Arrays.stream(input.split(COMMA))
            .collect(Collectors.toList());
    }

    // String 리스트를 Integer 리스트로 변환하는 기능
    private static List<Integer> stringListToIntegerList(List<String> input) {
        return input.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

}
