package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.NumberVerification;
import lotto.exception.ThousandUnitVerification;

public class PurchaseAmount {
    public int putAmount() {

        String unverifiedAmount = Console.readLine();
        int amount = NumberVerification.verify(unverifiedAmount);
        ThousandUnitVerification.unitVerify(amount);

        return amount;
    }// putAmount
}// end class
