package lotto.view;

import static lotto.constant.InputConstant.ASK_BONUS_NUMBER_MESSAGE;
import static lotto.constant.InputConstant.ASK_NUMBERS_MESSAGE;
import static lotto.constant.InputConstant.PURCHASE_AMOUNT_MESSAGE;
import static lotto.util.TypeConversion.stringToIntList;
import static lotto.util.TypeConversion.stringToInt;
import static lotto.util.Validator.*;
import static lotto.util.Validator.validateUnitStandard;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public static int askPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE.getMessage());
        String input = Console.readLine();

        int purchaseAmount = stringToInt(input);
        validatePositiveNumber(purchaseAmount);
        validateUnitStandard(purchaseAmount);

        return purchaseAmount;
    }

    public static List<Integer> askNumbers() {
        System.out.println(ASK_NUMBERS_MESSAGE.getMessage());
        String input = Console.readLine();

        List<Integer> playerNumbers = stringToIntList(input);
        validateLottoNumbersCount(playerNumbers);
        validateLottoNumbersRange(playerNumbers);
        validateLottoNumbersDuplication(playerNumbers);

        return playerNumbers;
    }

    public static int askBonusNumber(List<Integer> playerNumbers) {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE.getMessage());
        String input = Console.readLine();

        int bonusNumber = stringToInt(input);
        validateLottoNumberRange(bonusNumber);
        validateBonusNumberDuplicationInPlayerNumbers(bonusNumber, playerNumbers);

        return bonusNumber;
    }
}
