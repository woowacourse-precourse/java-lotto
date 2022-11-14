package lotto;

import lotto.print.PrintInputMessage;
import lotto.print.PrintOutputMessage;
import lotto.LottoAmount;
import lotto.CreateLottoNum;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void start() {
        LottoAmount purchaseAmount = inputLottoAmount();
        List<Lotto> userLottoNumbers = createLottoNumbers(purchaseAmount);
    }

    private LottoAmount inputLottoAmount() {
        try {
            return new LottoAmount(PrintInputMessage.getPurchaseAmount());
        } catch (IllegalArgumentException e) {
            PrintOutputMessage.printException(e);
            return  inputLottoAmount();
        }
    }

    private int countLottoTickets(LottoAmount purchaseAmount)  {
        int countTickets = purchaseAmount.countTickets();
        PrintOutputMessage.printLottoAccount(countTickets);
        return countTickets;
    }
    private List<Lotto> createLottoNumbers(LottoAmount purchaseAmount) {
        int countTickets = countLottoTickets(purchaseAmount);

        System.out.println(countTickets);

    }

}
