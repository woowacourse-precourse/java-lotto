package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.PurchaseException;

import static lotto.util.InputUtil.toIntFromString;

public class InputView {
    private final PurchaseException purchaseException = new PurchaseException();

    public int inputAmount() {
        String amount = Console.readLine();
        purchaseException.isValidPurchase(amount);
        return toIntFromString(amount);
    }

    public String inputLottoNumbers() {
        return Console.readLine();
    }

    public String inputBonusNumber() {
        return Console.readLine();
    }
}