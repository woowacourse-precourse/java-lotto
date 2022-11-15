package lotto;

import Info.InputException;
import Info.PrintGameInfo;
import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static final String COMMA = ",";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PrintGameInfo.purchaseAmountInfo();

        try {
            String amount = inputAmount();
            LottoList userLotto = new LottoList(new BigInteger(amount));
            PrintGameInfo.printNextLine();

            PrintGameInfo.purchaseCount(userLotto.getLottoCount());
            PrintGameInfo.lottoInfoList(userLotto);
            PrintGameInfo.printNextLine();

            PrintGameInfo.winningNumberInfo();
            userLotto.setWinningNumber(inputLottoWinningNumbers());
            PrintGameInfo.printNextLine();

            PrintGameInfo.bonnusNumberInfo();
            userLotto.setBonnusNumber(inputBonnusNumber());
            PrintGameInfo.printNextLine();

            userLotto.checkAllLotto();

            PrintGameInfo.winningTotalInfo();
            PrintGameInfo.lottoResultInfo(userLotto);
            PrintGameInfo.lottoProfitInfo(userLotto.getProfit());
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

    public static List<Integer> inputLottoWinningNumbers() {
        String userInput = Console.readLine();
        InputException.wrongWinningNumberFormat(userInput);

        List<String> winningNumber = Arrays.asList(userInput.split(COMMA));
        return Lotto.getIntNumbers(winningNumber);
    }

    public static int inputBonnusNumber() {
        String userInput = Console.readLine();
        InputException.emptyException(userInput);
        InputException.outOfDigitException(userInput);

        int bonnusNumber = Integer.valueOf(userInput);
        Lotto.isOutOfRangeException(bonnusNumber);
        return bonnusNumber;
    }
}
