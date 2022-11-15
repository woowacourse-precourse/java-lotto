package lotto;

import java.util.List;

import static lotto.Exception.*;
import static lotto.Utility.*;

public class Application {
    public static void main(String[] args) {
        printMessage(inputAmountMessage);
        String money = receiveInput();
        boolean checkNumericResult = checkNumeric(money);
        if(checkNumericResult){
            divisible(money);
        }
    }

    public static void divisible(String money){
        long _money = convertStringToLong(money);
        boolean checkDivisibleResult = checkDivisible(_money, divisorNumber);
        if(checkDivisibleResult){
            winningNumbersNumeric(_money);
        }
    }

    public static void winningNumbersNumeric(long money){
        long howManyLotto = calculateQuotient(money, divisorNumber);
        printMessage(Long.toString(howManyLotto).concat(purchaseLottoMessage));
        List<Lotto> purchaseLotto = totalPurchaseLotto(howManyLotto);
        printMessage(inputWinningNumbers);
        String winningNumbers = receiveInput();
        List <String> _winningNumbers = splitWinningNumbers(winningNumbers);
        boolean checkWinningNumbersNumericResult = checkWinningNumbersNumeric(_winningNumbers);
        if(checkWinningNumbersNumericResult){
            winningNumbersSize(money, purchaseLotto, _winningNumbers);
        }
    }

    public static void winningNumbersSize(long money, List<Lotto> purchaseLotto, List <String> winningNumbers){
        List <Integer> _winningNumbers = winningNumbersToInt(winningNumbers);
        boolean checkWinningNumbersSizeResult = checkWinningNumbersSize(_winningNumbers);
        if(checkWinningNumbersSizeResult){
            distinctNumbers(money, purchaseLotto, _winningNumbers);
        }
    }

    public static void distinctNumbers(long money, List<Lotto> purchaseLotto, List <Integer> winningNumbers){
        boolean checkDistinctNumbersResult = checkDistinctNumbers(winningNumbers);
        if(checkDistinctNumbersResult){
            numberRange(money, purchaseLotto, winningNumbers);
        }
    }

    public static void numberRange(long money, List<Lotto> purchaseLotto, List <Integer> winningNumbers){
        boolean checkNumberRangeResult=true;
        for(int i=0; i<winningNumbers.size(); i++) {
            checkNumberRangeResult = checkNumberRange(minLottoNumber, maxLottoNumber, winningNumbers.get(i));
        }
        if(checkNumberRangeResult){
            numeric(money, purchaseLotto, winningNumbers);
        }
    }
    public static void numeric(long money, List<Lotto> purchaseLotto, List <Integer> winningNumbers){
        printMessage(inputBonusNumber);
        String bonusNumber = receiveInput();
        boolean checkNumericResult = checkNumeric(bonusNumber);
        if(checkNumericResult){
            _numberRange(money, purchaseLotto, winningNumbers, bonusNumber);
        }
    }

    public static void _numberRange(long money, List<Lotto> purchaseLotto, List <Integer> winningNumbers, String bonusNumber){
        int _bonusNumber = (int)convertStringToLong(bonusNumber);
        boolean checkNumberRangeResult = checkNumberRange(minLottoNumber, maxLottoNumber, _bonusNumber);
        if(checkNumberRangeResult){
            distinctNumber(money, purchaseLotto, winningNumbers,_bonusNumber);
        }
    }

    public static void distinctNumber(long money, List<Lotto> purchaseLotto, List <Integer> winningNumbers, int bonusNumber){
        boolean checkDistinctNumberResult = checkDistinctNumber(winningNumbers, bonusNumber);
        if(checkDistinctNumberResult){
            end(money, purchaseLotto, winningNumbers, bonusNumber);
        }
    }

    public static void end(long money, List<Lotto> purchaseLotto, List <Integer> winningNumbers, int bonusNumber){
        printMessage(winningStatistics);
        printMessage(separateLine);
        List <Integer> lottoResult = findTotalLottoResult(purchaseLotto, winningNumbers, bonusNumber);
        printLottoResult(lottoResult);

        long totalPrizeAmount = calculateTotalPrizeAmount(lottoResult);
        double profitPercentage = calculateProfitPercentage(money, totalPrizeAmount);
        printProfitPercentage(profitPercentage);
    }
}
