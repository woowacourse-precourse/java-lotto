package view;

import lotto.Lotto;
import lotto.LottoTickets;

public class OutputView {
    public static final String TICKET_PURCHASED_MESSAGE = "개를 구매했습니다.";

    public static void printTicketPurchasedMessage(int count) {
        System.out.println(System.lineSeparator() + count + TICKET_PURCHASED_MESSAGE);
    }

    public static void printGeneratedLottoTickets(LottoTickets lottoTickets) {
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
