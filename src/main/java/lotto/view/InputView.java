package lotto.view;

import lotto.validator.ValidBonusNumber;
import lotto.validator.ValidatePurchaseAmt;
import lotto.validator.ValidateWinningNumber;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final ValidatePurchaseAmt validatePurchaseAmt = new ValidatePurchaseAmt();
    private static final ValidateWinningNumber validateWinningNumber = new ValidateWinningNumber();
    private static final ValidBonusNumber validateBonusNumber = new ValidBonusNumber();

    public static int readPurchaseAmt() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        validatePurchaseAmt.validate(input);
        return Integer.parseInt(input);
    }

    public static String readWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = readLine();
        validateWinningNumber.validate(input);
        return input;
    }

    public static int readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = readLine();
        validateBonusNumber.validate(input);
        return Integer.parseInt(input);
    }
}
