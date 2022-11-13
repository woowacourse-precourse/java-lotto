package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.view.message.FixedMessage;

public class OutputView {

    public void printLottoTicketInformation(List<Lotto> lottoTicket) {
        System.out.println("\n" + lottoTicket.size() + FixedMessage.OUTPUT_LOTTO_COUNT.getMessage());
    }
}
