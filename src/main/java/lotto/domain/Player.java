package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.valid.Validation;

public class Player {
    private int purchaseNumber;
    public void inputString(){
        purchaseNumber = Integer.parseInt(Console.readLine());
        Validation.purchaseNumberValid(purchaseNumber);
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }
}
