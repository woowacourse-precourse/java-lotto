package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.enums.BuyerPrint;
import lotto.domain.enums.PurchaseAmountUnit;


public class Buyer {
    int lottoAmount;

    static void validConsistByNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    static int inputLottoAmount(){
        int purchaseAmount;
        String inputValue;
        PurchaseAmountUnit purchaseAmountUnit = PurchaseAmountUnit.LOTTO_PURCHASE_UNIT;

        System.out.println(BuyerPrint.ENTER_PURCHASE_AMOUNT_MESSAGE);
        inputValue = Console.readLine();

        validConsistByNumber(inputValue);
        purchaseAmount = Integer.parseInt(inputValue);
        purchaseAmountUnit.validDivisionByThousand(purchaseAmount);

        return purchaseAmount;
    }
}
