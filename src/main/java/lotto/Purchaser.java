package lotto;

import camp.nextstep.edu.missionutils.Console;

import static resource.ErrorMessage.NOT_NUMBER_ERROR;
import static resource.ErrorMessage.OUT_OF_PURCHASE_AMOUNT_ERROR;

public class Purchaser {
    public int inputPurchaseAmount() {
        String tempPurchaseAmount = Console.readLine();
        for (int i = 0; i < tempPurchaseAmount.length(); i++) {
            if (Character.getNumericValue(tempPurchaseAmount.charAt(i)) < 0
                    || Character.getNumericValue(tempPurchaseAmount.charAt(i)) > 9) {
                throw new IllegalArgumentException(NOT_NUMBER_ERROR);
            }
        }
        int purchaseAmount = Integer.parseInt(tempPurchaseAmount);
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public int countPurchaseGame(int purchaseAmount) {
        int purchaseGame = purchaseAmount / 1000;
        return purchaseGame;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (!(purchaseAmount % 1000 == 0)) {
            throw new IllegalArgumentException(OUT_OF_PURCHASE_AMOUNT_ERROR);
        }
    }


}
