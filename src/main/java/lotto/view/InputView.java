package lotto.view;

import static lotto.util.TypeConversion.stringToIntList;
import static lotto.util.TypeConversion.stringToInt;
import static lotto.util.Validator.*;
import static lotto.util.Validator.validateUnitStandard;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static int askPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();

        int purchaseAmount = stringToInt(input);
        validateUnitStandard(purchaseAmount);

        return purchaseAmount;
    }

    public static List<Integer> askNumbers() {
        System.out.println(ASK_NUMBERS_MESSAGE);
        String input = Console.readLine();

        List<Integer> playerNumbers = stringToIntList(input);
        validatePlayNumbersCount(playerNumbers);
        validatePlayNumbersRange(playerNumbers);
        validatePlayNumbersDuplication(playerNumbers);

        return playerNumbers;
    }

    public static int askBonusNumber(List<Integer> playerNumbers) {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();

        int bonusNumber = stringToInt(input);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicationInPlayerNumbers(bonusNumber, playerNumbers);

        return bonusNumber;
    }
}
