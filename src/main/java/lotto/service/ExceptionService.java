package lotto.service;

import lotto.service.exceptionType.AmountException;
import lotto.service.exceptionType.WinningNumbersException;

public class ExceptionService {
    private static AmountException amountException = new AmountException();
    private static WinningNumbersException winningNumbersException = new WinningNumbersException();

    public void exceptionHandlingOfPurchaseAmount(String purchaseAmount) {
        amountException.checkIfAnAmountIsConvertibleToNumber(purchaseAmount);
        amountException.checkIfAmountIsDivisibleByOneThousand(purchaseAmount);
        amountException.checkIfAmountIsPositive(purchaseAmount);
    }

    public void exceptionHandlingOfWinningNumbers(String winningNumbers){
        winningNumbersException.checkIfTheWinningNumbersHasSixCharactersBasedOnTheConma(winningNumbers);
        winningNumbersException.checkForSpacesInWinningNumbers(winningNumbers);
        winningNumbersException.checkForDupliCateWinningNumbers(winningNumbers);
    }


}
