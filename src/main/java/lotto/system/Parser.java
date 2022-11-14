package lotto.system;

import lotto.exception.IllegalArgument;

public class Parser {

    public int validatePurchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        purchaseAmount = purchaseAmount.replaceAll(",", "");
        if (!IllegalArgument.isNumber(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 숫자만 입력 가능합니다.");
        }
        if (!IllegalArgument.isThousandWon(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(purchaseAmount);
    }
}
