package lotto.domain;

import lotto.Util.InputPrint;
import lotto.valid.Validation;


public class Player {
    private int purchaseNumber;

    public void inputMoney() {
        String startInput = InputPrint.startInput();
        try {
            Validation.purchaseNumberValid(startInput);
        } catch (Exception e) {
            return;
        }
        purchaseNumber = Integer.parseInt(startInput);
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }
}
