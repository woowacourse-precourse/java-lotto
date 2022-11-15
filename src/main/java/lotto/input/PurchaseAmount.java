package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.NumberCheckException;
import lotto.exception.ThousandUnitCheckException;

public class PurchaseAmount {
    public int putAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String unverifiedAmount = Console.readLine();
        int amount = NumberCheckException.check(unverifiedAmount);
        ThousandUnitCheckException.unitCheck(amount);

        return amount;
    }// putAmount
}// end class
