package lotto.service;

import lotto.util.ArgumentExceptionMessage;
import lotto.util.LottoConstant;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/14
 */
public class LottoService {
    public int toPurchaseAmount(String input) {
        validPurchaseAmount(input);
        int purchaseAmount = toInteger(input);
        isDivideThousand(purchaseAmount);
        return purchaseAmount / LottoConstant.LOTTO_PRICE.getValue();
    }

    private void validPurchaseAmount(String input) {
        isNumeric(input);
    }

    private int toInteger(String input) {
        return Integer.parseInt(input);
    }

    private void isDivideThousand(int purchaseAmount) {
        if (purchaseAmount % LottoConstant.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_PURCHASE_AMOUNT_UNCONFORMABLE_VALUE.getMessage());   // 구매 금액이 1000원 단위가 아닌 경우
        }
    }

    private void isNumeric(String input) {
        if (!input.matches("[1-9]+[0-9]*")) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_NOT_INTEGER.getMessage());   // 입력받은 값이 정수로 표현되지 않는 경우
        }
    }
}
