package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.NumberVerification;
import lotto.exception.ThousandUnitVerification;

public class PurchaseAmount {
    public int putAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String unverifiedAmount = Console.readLine();
        int amount = NumberVerification.verify(unverifiedAmount);
        ThousandUnitVerification.unitVerify(amount);

        return amount;
    }// putAmount
}// end class
