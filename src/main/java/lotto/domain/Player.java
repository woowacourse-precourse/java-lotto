package lotto.domain;

import lotto.Util.InputPrint;
import lotto.valid.Validation;


public class Player {
    private int purchaseNumber;

    private int sum;

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

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
