package lotto;

import lotto.print.PrintInputMessage;
import lotto.print.PrintOutputMessage;
import lotto.LottoRank;
import lotto.LottoCalculator;
import lotto.LottoAmount;
import lotto.CreateLottoNum;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Controller {

    private static List<Integer> inputUserWinningNumber;
    private static int winBonusNumber;

    private static final int LOTTO_WIN_SIZE = 6;
    private static final int ZERO = 0;


    public static void start() {
        try {
            LottoAmount purchaseAmount = inputLottoAmount();
            List<Lotto> userLottoNumbers = createLottoNumbers(purchaseAmount);
            PrintOutputMessage.printUserLottoNumbers(userLottoNumbers);
            inputUserWinningNumber = inputWinningNumber();
            winBonusNumber = inputBonusNumber(inputUserWinningNumber);
            printLottoResult(userLottoNumbers, inputUserWinningNumber, winBonusNumber, purchaseAmount);
        } catch (IllegalArgumentException e) {
            PrintOutputMessage.printException(e);
        }
    }

    private static LottoAmount inputLottoAmount() {
        return new LottoAmount(PrintInputMessage.getPurchaseAmount());
    }

    private static List<Lotto> createLottoNumbers(LottoAmount purchaseAmount) {
        List<Lotto> userLottoNumbers = CreateLottoNum.getLottoNumbers(purchaseAmount);
        return userLottoNumbers;
    }

    private static List<Integer> inputWinningNumber() {
        List<Integer> makeWinningNumber = PrintInputMessage.getWinningLottoNumber();
        Lotto.validateLottoNumbers(makeWinningNumber);
        return makeWinningNumber;
    }

    private static int inputBonusNumber(List<Integer> getWinningLottoNum) { // 입력 범위 오류

        return PrintInputMessage.getBonusLottoNumber(getWinningLottoNum);
    }

    private static void printLottoResult(List<Lotto> userLottoNumbers,
                        List<Integer> inputUserWinningNumber, int winBonusNumber, LottoAmount purchaseAmount) {

        int[] countWinPrize = new int[LOTTO_WIN_SIZE];

        for(int i = 0; i < userLottoNumbers.size(); i++) {
            countWinPrize =  LottoCalculator.calculateRank(userLottoNumbers.get(i),winBonusNumber, inputUserWinningNumber, countWinPrize);
        }
        PrintOutputMessage.printLottoRank(countWinPrize);
        PrintOutputMessage.printLottoRatio(purchaseAmount, countWinPrize);
    }

}
