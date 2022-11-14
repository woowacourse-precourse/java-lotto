package lotto;

import lotto.print.PrintInputMessage;
import lotto.print.PrintOutputMessage;
import lotto.LottoAmount;

public class Controller {
    public void start() {
        LottoAmount purchaseAmount = inputLottoAmount();
    }

    private LottoAmount inputLottoAmount() {
        try {
            return new LottoAmount(PrintInputMessage.getPurchaseAmount());
        } catch (IllegalArgumentException e) {
            PrintOutputMessage.printException(e);
            return  inputLottoAmount();
        }
    }




}
