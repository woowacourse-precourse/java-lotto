package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.util.constants.GameConstants;

public class GameMessage {

    public void printInputPurchaseAmount() {
        print(GameConstants.INPUT_PURCHASE_AMOUNT);
    }

    public void printLottoTicketCount(int lottoTicketCount) {
        print("\n" + lottoTicketCount + GameConstants.OUTPUT_PURCHASE_LOTTO_COUNT);
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            printLottoNumber(lottoTicket.getNumbers());
        }
    }

    public void printLottoNumber(List<Integer> lotto) {
        String[] lottoArray = lotto.stream().map(String::valueOf).toArray(String[]::new);
        print(Arrays.toString(lottoArray));
    }

    public void print(String printString) {
        System.out.println(printString);
    }
}
