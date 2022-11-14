package lotto.service;

import lotto.service.exceptionType.AmountException;

public class ExceptionService {
    private static AmountException amountException = new AmountException();

    public void exceptionHandlingOfPurchaseAmount(String purchaseAmount) {
        amountException.checkIfAnAmountIsConvertibleToNumber(purchaseAmount);
    }


}
