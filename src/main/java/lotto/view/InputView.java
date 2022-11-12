package lotto.view;

import static lotto.util.TypeConversion.stringToInt;
import static lotto.util.Validator.validateUnitStandard;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public int askPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();

        int purchaseAmount = stringToInt(input);

        validateUnitStandard(purchaseAmount);

        return purchaseAmount;
    }
}
