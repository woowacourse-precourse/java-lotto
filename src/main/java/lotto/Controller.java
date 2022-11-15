package lotto;

import lotto.print.PrintInputMessage;
import lotto.print.PrintOutputMessage;
import lotto.LottoAmount;
import lotto.CreateLottoNum;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static List<Integer> inputUserWinningNumber;
    private static int winBonusNumber;

    public static void start() {
        LottoAmount purchaseAmount = inputLottoAmount();
        List<Lotto> userLottoNumbers = createLottoNumbers(purchaseAmount);
        PrintOutputMessage.printUserLottoNumbers(userLottoNumbers);
        inputUserWinningNumber = inputWinningNumber();

    }

    private static LottoAmount inputLottoAmount() {
        try {
            return new LottoAmount(PrintInputMessage.getPurchaseAmount());
        } catch (IllegalArgumentException e) {
            PrintOutputMessage.printException(e);
            return  inputLottoAmount();
        }
    }

    private static int countLottoTickets(LottoAmount purchaseAmount)  {
        int countTickets = purchaseAmount.countTickets();
        PrintOutputMessage.printLottoAccount(countTickets);
        return countTickets;
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

}
