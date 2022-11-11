package lotto.view;

import lotto.model.Lotto;
import lotto.model.Ticket;

import java.util.List;

public class TicketView {
    public static void outPut(Ticket ticket) {
        int lottoCount = ticket.getMoney() / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> lotteries = ticket.getLotteries();
        for (Lotto lottery : lotteries) {
            System.out.println(lottery);
        }
    }
}
