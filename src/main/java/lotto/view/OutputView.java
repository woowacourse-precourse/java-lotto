package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.Tickets;

public class OutputView {

    public static void printTickets(Tickets tickets) {
        List<Lotto> lottoTickets = tickets.getLottoTickets();
        int count = lottoTickets.size();

        System.out.printf("%d개를 구매했습니다.\n", count);
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

}
