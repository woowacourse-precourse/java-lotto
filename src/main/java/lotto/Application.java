package lotto;

import Info.InputException;
import Info.PrintGameInfo;
import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PrintGameInfo.purchaseAmountInfo();

        try {
            String amount = inputAmount();
            LottoList userLotto = new LottoList(new BigInteger(amount));

            PrintGameInfo.purchaseCount(userLotto.getLottoCount());
            PrintGameInfo.lottoInfoList(userLotto);

            PrintGameInfo.winningNumberInfo();
            String winningNumber = Console.readLine();
            PrintGameInfo.bonnusNumberInfo();

        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

    }
    public static String inputAmount() {
        String amount = Console.readLine();
        InputException.emptyException(amount);
        InputException.outOfDigitException(amount);
        return amount;
    }

    public static String inputWinningNumbers() {
        String winningNumber = Console.readLine();
        InputException.wrongWinningNumberFormat(winningNumber);

        return winningNumber;
    }

    

}
