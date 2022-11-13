package lotto.view;

import static lotto.util.TypeConversion.stringListToIntList;
import static lotto.util.TypeConversion.stringToInt;
import static lotto.util.Validator.*;
import static lotto.util.Validator.validateUnitStandard;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public int askPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();

        int purchaseAmount = stringToInt(input);

        validateUnitStandard(purchaseAmount);

        return purchaseAmount;
    }

    public List<Integer> askNumbers() {
        System.out.println(ASK_NUMBERS_MESSAGE);
        String input = Console.readLine();

        List<Integer> playerNumbers = stringListToIntList(input);
        validatePlayNumbersCount(playerNumbers);
        validatePlayNumbersRange(playerNumbers);
        validatePlayNumbersDuplication(playerNumbers);

        return playerNumbers;
    }
}
