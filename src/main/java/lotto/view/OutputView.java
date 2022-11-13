package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoTicket;

import java.util.List;

public class OutputView {
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printTicketCount(long count) {
        System.out.println(count+"개를 구매했습니다.");
    }

    public static void printLottoTickets(LottoTicket lottoTicket){
        List<Lotto> lottoTickets = lottoTicket.getLottoTickets();
        System.out.println("asdasd");
    }
}
