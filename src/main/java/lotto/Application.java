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
            startLotto();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            //System.out.println(exception.getMessage());
        }
    }
    public static void startLotto() {
        String amount = inputAmount();
        LottoList userLotto = new LottoList(Long.valueOf(amount));
        PrintGameInfo.printNextLine();

        printPurchaseLotto(userLotto);
        getWinningNumber(userLotto);
        getBonnusNumber(userLotto);

        userLotto.checkAllLotto();
        printLottoResult(userLotto);
    }

    public static void printPurchaseLotto(LottoList userLotto) {
        PrintGameInfo.purchaseCount(userLotto.getLottoCount());
        PrintGameInfo.lottoInfoList(userLotto);
        PrintGameInfo.printNextLine();
    }

    /**
     * 로또 결과 출력
     * @param userLotto
     */
    public static void printLottoResult(LottoList userLotto) {
        PrintGameInfo.winningTotalInfo();
        PrintGameInfo.lottoResultInfo(userLotto);
        PrintGameInfo.lottoProfitInfo(userLotto.getProfit());
    }

    /**
     * 당청 번호 입력
     * @param userLotto
     */
    public static void getWinningNumber(LottoList userLotto) {
        PrintGameInfo.winningNumberInfo();
        userLotto.setWinningNumber(inputLottoWinningNumbers());
        PrintGameInfo.printNextLine();
    }

    /**
     * 보너스 번호 입력
     * @param userLotto
     */
    public static void getBonnusNumber(LottoList userLotto) {
        PrintGameInfo.bonnusNumberInfo();
        userLotto.setBonnusNumber(inputBonnusNumber());
        PrintGameInfo.printNextLine();
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
