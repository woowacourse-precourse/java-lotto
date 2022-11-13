package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LOTTO_TICKET_AMOUNT = "개를 구매했습니다.";

    public static void lottoTicketAmountMessage(int ticket) {
        System.out.println(ticket+LOTTO_TICKET_AMOUNT);
    }

    public static void printLottoTickets(List<Lotto> tickets) {
        for(int i = 0; i < tickets.size(); i++) {
            System.out.println(tickets.get(i).getNumbers());
        }
    }
}
