package lotto.service;

import lotto.service.exceptionType.AmountException;
import lotto.service.exceptionType.BonusNumberException;
import lotto.service.exceptionType.WinningNumbersException;

import java.util.List;

public class ExceptionService {
    private static AmountException amountException = new AmountException();
    private static WinningNumbersException winningNumbersException = new WinningNumbersException();
    private static BonusNumberException bonusNumberException = new BonusNumberException();

    public void exceptionHandlingOfPurchaseAmount(String purchaseAmount) {
        amountException.checkIfAnAmountIsConvertibleToNumber(purchaseAmount);
        amountException.checkIfAmountIsDivisibleByOneThousand(purchaseAmount);
        amountException.checkIfAmountIsPositive(purchaseAmount);
    }

    public void exceptionHandlingOfWinningNumbers(String winningNumbers){
        winningNumbersException.checkIfTheWinningNumbersHasSixCharactersBasedOnTheConma(winningNumbers);
        winningNumbersException.checkForSpacesInWinningNumbers(winningNumbers);
        winningNumbersException.checkForDupliCateWinningNumbers(winningNumbers);
        winningNumbersException.checkIfTheScopeIsCorrect(winningNumbers);
    }

    public void exceptionHandlingOfBonusNumber(List<Integer> winningNumbers, String bonusNumber){
        bonusNumberException.checkIfBonusNumberIsNumeric(bonusNumber);
        bonusNumberException.checkIfTheScopeIsCorrect(bonusNumber);
        bonusNumberException.checkForDuplicateBonusNumber(winningNumbers, bonusNumber);
    }
}
