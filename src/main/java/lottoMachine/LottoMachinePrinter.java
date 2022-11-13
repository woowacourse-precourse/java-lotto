package lottoMachine;

import static lottoMachine.enums.Messages.RECEIVE_PRICE_MESSAGE;
import static lottoMachine.enums.Messages.RESULT_OF_PURCHASE_MESSAGE;

import java.text.MessageFormat;
import java.util.List;
import lotto.Lotto;

public class LottoMachinePrinter {

    private LottoMachinePrinter() {
    }


    public static void printReceivePriceMessage() {
        System.out.println(RECEIVE_PRICE_MESSAGE);
    }

    public static void printPurchaseAmount(int amount) {
        String format = MessageFormat.format(RESULT_OF_PURCHASE_MESSAGE.toString(), amount);
        System.out.println(format);
    }

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }
}
